package bo;

import java.util.ArrayList;

public class Matrix {
    ArrayList<ArrayList<Integer>> matrix;

    public Matrix( int rows, int cols ) {
        this.matrix = new ArrayList<>();

        for(int i = 0; i < rows; i++ ) {
            matrix.add(new ArrayList() );

            for(int j = 0; j < cols; j++ ) {
                matrix.get(i).add( 0 );
            }
        }
    }

    public int getNumberOfRows( ) {
        return this.matrix.size();
    }

    public int getNumberOfCols( ) {
        return this.matrix.get(0).size();
    }

    public Integer getValue( int row, int col ) throws Exception {
        if( row < this.getNumberOfRows() )
            if( col < this.getNumberOfCols() )
                return this.matrix.get( row ).get( col );

        throw new Exception( "index out of bound" );
    }

    public boolean setValue( int row, int col, Integer value) throws Exception {
        if( row < this.getNumberOfRows() )
            if( col < this.getNumberOfCols() ) {
                this.matrix.get(row).set(col, value);

                return true;
            }

        throw new Exception( "index out of bound" );
    }

    public void print() throws Exception {
        for( int i = 0; i < this.getNumberOfRows(); i++ ){
            for( int j = 0; j < this.getNumberOfCols(); j++ ){
                System.out.print( this.getValue( i, j ) + "\t" );
            }
            System.out.println();
        }
        System.out.println();
    }

    public void print( PizzasResult items ) throws Exception {
        boolean highlighted = false;

        for( int i = 0; i < this.getNumberOfRows(); i++ ){
            for( int j = 0; j < this.getNumberOfCols(); j++ ){
                highlighted = false;

                if( items.containsKey( i ) && items.get( i ) == j )
                    highlighted = true;

                if( highlighted )
                    System.out.print( ConsoleColors.RED );

                System.out.print( this.getValue( i, j ) + "\t" );

                if( highlighted )
                    System.out.print( ConsoleColors.WHITE );


            }
            System.out.println();
        }
        System.out.println();
    }

}
