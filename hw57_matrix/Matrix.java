//Sophia Xia
//APCS1 pd1
//HW57 -- How Deep Does the Rabbit Hole Go?
//2017-12-19

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

    //incorrect constructors kind of screwed me up...
    //I wasn't able to call any methods in the main method
    //so I wasn't sure how to populate my array
    //I should make sure my foundation is solid...
    //Although all my methods did end up working even though I coded all at once
    //later on I asked Thet about his pop and I did what he did
    //but his worked so I knew something else was wrong (AKA cons)
    
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
	return matrix[r][c];
    }


    //return true if this matrix is empty, false otherwise
    //matrix is empty if each 
    //O(n^2): Quadratic
    private boolean isEmpty() 
    {
	//for each row in matrix
	for(Object[]r: matrix){
	    //for each element in that row
	    for(Object c: r){
		//ret false if it is null
		if (c != null){
		    return false;
		}
	    }
	}
	return true;
    }


    //overwrite item at specified row and column with newVal
    //return old value
    //O(1): Constant
    private Object set( int r, int c, Object newVal ) 
    {
	Object temp = matrix[r][c];
	matrix[r][c] = newVal;
	return temp;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    // O(n^2): Quadratic
    public String toString() 
    {
	String str = "-------------------------Matrix-------------------------";
	System.out.println("Empty?" + isEmpty());
	if (!isEmpty()){
	    for(Object[]r: matrix){
		str = str + "\n|\t";
		for(Object c: r){
		    str = str +  c + "\t";
		}
		str = str + "|";
	    }
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
		    if(this.matrix[r][c] != ((Matrix)rightSide).matrix[r][c]){
			return false;
		    }
		}
		return true;
	    }
	}
	return false;
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


    //main method for testing
    public static void main( String[] args ) 
    {
	Matrix meow = new Matrix(10);
	System.out.println(meow);
	System.out.println(meow.size());
	int Ctr = 1;
	for (int r = 0; r < meow.size(); r++) {
	    for (int c = 0; c < meow.size(); c++ ) {
		meow.set(r, c, Ctr);
		Ctr += 1;
	    }
	}
        System.out.println(meow);
	meow.swapRows(1,2);
	System.out.println(meow);
	meow.swapColumns(9,10);
	System.out.println(meow);
	
	Matrix woof = new Matrix(10);
	System.out.println(woof);
	System.out.println(woof.size());
	for (int r = 0; r < woof.size(); r++) {
	    for (int c = 0; c < woof.size(); c++ ) {
		woof.set(r, c, 1);
	    }
	}
        System.out.println(woof);
	System.out.println("woof equals meow?" + woof.equals(meow));

	
	Matrix chirp = new Matrix(10);
	System.out.println(chirp);
	System.out.println(chirp.size());
	for (int r = 0; r < chirp.size(); r++) {
	    for (int c = 0; c < chirp.size(); c++ ) {
		chirp.set(r, c, 1);
	    }
	}
        System.out.println(chirp);
	System.out.println("Chirp equals woof?" + chirp.equals(woof));
    }

}//end class Matrix
    
