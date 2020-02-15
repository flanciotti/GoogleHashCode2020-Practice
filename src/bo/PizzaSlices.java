package bo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class PizzaSlices extends ArrayList<Integer> {
    public boolean add( String s ) {

        StringTokenizer st = new StringTokenizer( s );
        while (st.hasMoreTokens()) {
            this.add( Integer.parseInt( st.nextToken() ) );
        }

        return true;
    }

    @Override
    public String toString() {
        String result = "";

        result += "PizzaSlices size: " + this.size() + "\n";

        return result;
    }

    public int sum() {
        int result = 0;

        Iterator it = this.iterator();
        while( it.hasNext() )
            result += (int) it.next();


        return result;
    }

}
