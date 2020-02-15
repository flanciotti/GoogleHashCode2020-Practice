package bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PizzasResult extends HashMap<Integer, Integer> {

    @Override
    public String toString() {
        String result = "";
        Iterator it = this.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            result += pair.getKey() + "->" + pair.getValue() + ", ";
        }

        return result;
    }

    public String scoreToString() {
        String result = "";
        int sum = 0;

        Iterator it = this.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            if( result.length() > 0 )
                result += '+';

            result += pair.getValue();
            sum += (int) pair.getValue();
        }

        result += '=' + sum;

        return result;
    }

    public int score() {
        int sum = 0;

        Iterator it = this.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            sum += (int) pair.getValue();
        }

        return sum;
    }

    public String listToString() {
        String result = "";
        Iterator it = this.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            result += pair.getKey() + " ";
        }

        return result;
    }

    public String numberOfPizzasToString() {
        String result = "" + this.size();

        return result;
    }

    public boolean add( int start, PizzaSlices ps ) {

        for( int i = 0; i < ps.size(); i++ ) {
            this.put(start + i, ps.get( i ) );
        }

        return true;
    }


}
