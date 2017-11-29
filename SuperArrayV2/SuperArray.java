// Team Lonely Sparklers
// Roster: Sophia Xia, Thet Htay Zaw
// APCS pd1
// HW42 -- Array of Grade 316
// 2017-11-28

/***************************
 * class SuperArray version 2.0
 * (SKELETON)
 * Wrapper class for array. Facilitates
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 ***************************/

public class SuperArray
{

    private int[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


    //default constructor – initializes 10-item array
    public SuperArray()
    {
	_data = new int[10];
	_size = 0;
    }

    
    //output SuperArray in [a,b,c] format
    public String toString()
    {
	String foo = "[";
	for( int i = 0;
	     i < _size;
	     i++ ) {
	    foo += _data[i] + ",";
	}
	if ( foo.length() > 1 )
	    //shave off trailing comma
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    //double capacity of SuperArray
    private void expand()
    {
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }


    //accessor -- return value at specified index
    public int get( int index )
    {
	return _data[index];
    }


    //=====================================================================

    //mutator -- set value at index to newVal,
    //           return old value at index
    public int set( int index, int newVal )
    {
	int temp = _data[index];
	_data[index] = newVal;
	// alter size, otherwise arrays will be printed as empty
	if(_size <= index){
	    _size = _size +1;
	}
	return temp;
    }


    //adds an item after the last item
    public void add( int newVal )
    {
	//create temp array one index longer than _data
	int[] temp = new int[ _size +1 ];
	//copy contents of _data into array
	for( int i = 0;
	     i < _size;
	     i++ )
	    temp[i] = _data[i];
	//sets value of the last index
	temp[temp.length-1] = newVal;
	//sets _data to the temp array and updates _size
	_data = temp;
	_size = _size +1;
    }


    //inserts an item at index
    public void add( int index, int newVal )
    {
	int ctr = 0;
	//Create temp array one index longer than _data
	int[] temp = new int[_size + 1];
	//Copy 0 to param index of _data into temp array
	for (int i = 0 ; i < index ; i++ ) {
	    temp[i] = _data[i];
	    ctr = ctr + 1;
	}
	//sets the index right after the param index to the newVal
	temp[ctr] = newVal;
	ctr = ctr + 1;
	//Copy all contents after the param index in _data to temp array 
	for (int i = ctr - 1 ; i < _size ; i++ ) {
	    temp[ctr] = _data[i];
	    ctr = ctr + 1;
	}
	//sets _data to temp array and updates _size
	_data = temp;
	_size = _size + 1;
	
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index )
    {
	//creates temp array one index shorter than _data
	int[] temp = new int[_size -1];
	//copies from _data up to param index into temp array 
	for( int i = 0;
	     i < index -1;
	     i ++){
	    temp[i] = _data[i];
	}
	//copies the rest of data after the param index into temp array
	for( int i = index -1;
	     i < _size -1;
	     i ++){
	    temp[i] = _data[i +1];
	}
	//sets _data to temp array and updates _size
	_size = _size -1;
	_data = temp;
    }

    
    //return number of meaningful items in _data
    public int size()
    {
	return _size;
    }

    
    //main method for testing
    public static void main( String[] args )
    {
	SuperArray curtis = new SuperArray();
	System.out.println( "Printing empty SuperArray curtis..." );
	System.out.println( curtis ); // []

	for( int i = 0;
	     i < curtis._data.length;
	     i++ ) {
	    curtis.set( i, i * 2 );
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis); // [0,2,4,6,8,10,12,14,16,18]

	for( int i = 0; i < 3; i++ ) {
	    curtis.expand();
	    System.out.println("Printing expanded SuperArray curtis...");
	    System.out.println(curtis);
	    System.out.println("new length of underlying array: "
			       + curtis._data.length );
	}
	// Printing expanded SuperArray curtis...
	// [0,2,4,6,8,10,12,14,16,18]
	// new length of underlying array: 20

	// Printing expanded SuperArray curtis...
	// [0,2,4,6,8,10,12,14,16,18]
	// new length of underlying array: 40

	// Printing expanded SuperArray curtis...
	// [0,2,4,6,8,10,12,14,16,18]
	// new length of underlying array: 80


	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield); // []

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield); // [5,4,3,2,1]
	
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield); // [5,4,2,1]
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield); // [5,4,1]
	
	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield); // [5,4,1,99]
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield); // [5,4,88,1,99]
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield); // [5,77,4,88,1,99]

    }//end main()
    
}//end class
