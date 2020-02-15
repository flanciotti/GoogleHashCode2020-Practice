package bo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Output {
    protected static PizzasResult pr;

    public static void printSummary(){
        System.out.println("score: " + pr.scoreToString());
    }

    public static void save(String filename, PizzasResult pr ) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        System.out.println("Saving " + filename);
        try {
            fw = new FileWriter(filename);
            bw = new BufferedWriter(fw);
            bw.write( pr.numberOfPizzasToString() );
            bw.write( "\n" );
            bw.write( pr.listToString() );

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}
