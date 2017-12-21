//Sophia Xia
//APCS1 pd1
//HW59 -- Make the Matrix Work For You
//2017-12-20

/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;

    
    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    //O(1): Constant
    public Matrix( ) 
    {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }
    

    //constructor intializes an a*a matrix
    //O(1): Constant
    public Matrix( int a ) 
    {
	matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    //O(1): Constant
    private int size() 
    {
	return matrix.length;
    }


    //return the item at the specified row & column   
    //O(1): Constant
    private Object get( int r, int c ) 
    {
	return matrix[r-1][c-1];
    }


    //return true if this matrix is empty, false otherwise
    //matrix is empty if each 
    //O(1): Constant
    private boolean isEmpty(int r, int c) 
    {
	return get(r, c) == null;
    }


    //overwrite item at specified row and column with newVal
    //return old value
    //O(1): Constant
    private Object set( int r, int c, Object newVal ) 
    {
	Object temp = matrix[r-1][c-1];
	matrix[r-1][c-1] = newVal;
	return temp;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    // O(n^2): Quadratic
    public String toString() 
    {
	String str = "-------------------------Matrix-------------------------";
	for(Object[]r: matrix){
	    str = str + "\n|\t";
	    for(Object c: r){
		str = str +  c + "\t";
	    }
	    str = str + "|";
	}
	return str;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    // O(n^2): Quadratic
    public boolean equals( Object rightSide ) 
    {
	if(!(rightSide instanceof Matrix)){
	    throw new ClassCastException("Invalid input: input must be a Matrix");
	}
	else if(this.size() == ((Matrix)rightSide).size()){
	    for(int r = 0; r < this.size(); r++){
		for(int c = 0; c < this.size(); c++){
		    if(this.matrix[r][c] !=
		       ((Matrix)rightSide).matrix[r][c]){
			return false;
		    }
		}return true;
	    }
	}return false;
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    // O(n): linear
    public void swapColumns( int c1, int c2  ) 
    {
	for(int r = 0; r < this.size(); r++ ){
	    Object temp = matrix[r][c1-1];
	    matrix[r][c1-1] = matrix[r][c2-1];
	    matrix[r][c2-1] = temp;
	}
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    // O(1): constant
    public void swapRows( int r1, int r2  ) 
    {
	Object[]temp = matrix[r1-1];
	matrix[r1-1] = matrix[r2-1];
	matrix[r2-1] = temp;
    }


    //=======================================================================
    //returns copy of row r
    //O(1): Constant
    public Object[] getRow( int r ) {
	return matrix[r];
    }


    //replaces row r with 1D array newRow
    //returns old row
    //O(1): Constant
    public Object [] setRow( int r, Object[] newRow ) {
	Object[]temp = newRow;
	matrix[r] = newRow;
	return temp;
    }


    //O(n): linear
    public Object [] setCol( int c, Object[] newCol ) {
	Object[]temp = newCol;
	for(int r = 0; r < size(); r++){
	    matrix[r][c] = newCol[r];
	}
	return temp;
    }
    

    //Props to Jason Kim from the QAF
    //probably saved me a good deal of time XD
    //you don't want to swap everything because you will end up swapping
    //twice resulting in the original 2D array
    //O(n^2): Quadratic
    public void transpose() {
	for(int r = 0; r < size(); r++){
	    for(int c = 0; c < r +1; c++){
		Object temp = matrix[r][c];
		matrix[r][c] = matrix[c][r];
		matrix[c][r] = temp;
	    }
	}
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	Matrix meow = new Matrix(10);
	System.out.println(meow);
	System.out.println(meow.size());
	int Ctr = 1;
	for (int r = 1; r < meow.size()+1; r++) {
	    for (int c = 1; c < meow.size()+1; c++ ) {
		meow.set(r, c, Ctr);
		Ctr += 1;
	    }
	}
	System.out.println(meow);
	meow.transpose();
	System.out.println(meow);
    }

}//end class Matrix
    
