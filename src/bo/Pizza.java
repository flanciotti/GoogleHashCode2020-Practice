package bo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pizza {
    protected int minSlices;
    protected int nPizzaTypes;
    protected PizzaSlices pizzaSlices;

    public Pizza(){

    }

    public Pizza( String filename ) throws IOException {
        FileReader input = new FileReader(filename);
        BufferedReader bufRead = new BufferedReader(input);
        String myLine = null;

        this.pizzaSlices = new PizzaSlices();

        boolean firstLine = true;
        while ( (myLine = bufRead.readLine()) != null)
        {
            if( firstLine ){
                String[] items = myLine.split(" ");
                this.minSlices = Integer.parseInt( items[0] );
                this.nPizzaTypes = Integer.parseInt( items[1] );

                firstLine = false;
            }
            else{
                this.pizzaSlices.add( myLine );
            }
        }
        bufRead.close();

        System.out.println( "requested slices: " + this.minSlices );
    }



    protected PizzasResult getMaxPizzas( PizzaSlices wt, int minSlices ) throws Exception {
        int i, w;
        int n = wt.size();
        Matrix K = new Matrix( n + 1, minSlices +1 );

        PizzasResult pr = new PizzasResult();

        for( i = 0; i <= n; i++ )
        {
            for( w = 0; w <= minSlices; w++ )
            {
                if ( i == 0 || w == 0 ) {
                    K.setValue(i, w,  0 );
                }
                else if( wt.get( i - 1 ) <= w ) {
                    int value =  Math.max(wt.get(i - 1) + K.getValue(i - 1, w - wt.get(i - 1) ), K.getValue( i - 1, w ));

                    K.setValue(i, w, value );
                }
                else {
                    int value =  K.getValue( i - 1, w );
                    K.setValue(i, w, value );
                }
            }

            // K.print();
        }


        // getting the items
        int result = K.getValue(n, minSlices);

        w = minSlices;
        for ( i = wt.size(); i > 0  &&  result > 0; i--) {
            if (result != K.getValue(i-1, w )) {
                pr.put( i - 1, wt.get(i-1) );

                result -= wt.get( i - 1 );
                w -= wt.get( i - 1 );
            }
        }

        return pr;
    }

    protected PizzasResult orderPizzas() throws Exception {
        PizzaSlices ps = new PizzaSlices();
        int s = 0;
        int extraSlices = 0;

        // simplify the problem
        do{
            s = this.pizzaSlices.sum();

            extraSlices = s - minSlices;

            if( extraSlices > 0 ) {
                int index = 0;
                ps.add(this.pizzaSlices.get( index ));
                this.pizzaSlices.remove( index );
            }
        } while( extraSlices > 0 );

        PizzasResult pr = getMaxPizzas( ps, -extraSlices );

        pr.add( ps.size(), this.pizzaSlices );

        return pr;
    }

    public PizzasResult run() throws Exception {
        PizzasResult pr = this.orderPizzas();

        return pr;
    }


    public String toString() {
        return "";
    }

}