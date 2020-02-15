import bo.*;

import java.io.IOException;


class HashCode2020Practice {
    protected void run(){
        try {
            String[] filename = {"./data/a_example.in", "./data/b_small.in", "./data/c_medium.in", "./data/d_quite_big.in", "./data/e_also_big.in"};

            for (String s : filename) {
                System.out.println( "\n\nopening file " + s );

                Pizza p = new Pizza(s);

                PizzasResult pr = p.run();

                Output.save( s + ".out", pr );

            }
        }
        catch( Exception e ){
            System.out.println( e );
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws IOException {
        HashCode2020Practice hc2019p = new HashCode2020Practice();

        hc2019p.run();
    }
}