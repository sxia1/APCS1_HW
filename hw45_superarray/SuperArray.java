//Sophia Xia
//APCS1 pd1
//HW45 -- In America, the Driver Sits on the Left
//2017-12-03

/***************************
 * class SuperArray version 4.0
 * Wrapper class for array. Facilitates resizing,
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 *
 * ...and now SuperArray complies with the specifications of the
 * List interface. (List.java must be in same dir as this file)
 ***************************/

//Note to self: if you aren't sure what the assignment is asking then ask
//someone else T^T, props to Thet for helping me out.
//sometimes, the assignment really is that simple so don't overthink it

//Also, it seems as though curly brackets aren't necessary in all cases
//However, I like them since it makes reading my code a little easier

public class SuperArray implements List
{

    private Object[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


    //default constructor – initializes 10-item array
    public SuperArray()
    {
	_data = new Object[10];
	_size = 0;
    }


    //output SuperArray in [a,b,c] format
    public String toString()
    {
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
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
	Object[] temp = new Object[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

    //========================================================================

    //return number of meaningful items in _data
    public int size(){
	return _size;
    }


    //adds an item after the last item
    public boolean add( Object o ){
	add( _size, o );
	return true;
    }


    //inserts an item at index
    public void add( int index, Object o ){
	//not sure why we should be hesitant to modify the standard in this case
	//taking out the equals from index >= _size seems like the best solution
	//I mean, no harm no foul right? It runs properly so...
	if (index < 0 || index > _size){
	    throw new IndexOutOfBoundsException("Index out of Range");
	}
	//first expand if necessary
	if ( _size >= _data.length )
	    expand();
	for( int i = _size;
	     i > index;
	     i-- ) {
	    _data[i] = _data[i - 1]; //each slot gets value of left neighbor
	}
	_data[index] = o;
	_size ++;
    }


    
    //accessor -- return value at specified index
    public Object get( int index )
    {
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("invalid index input");
	}
	else {
	    return _data[index];
	}
    }


    //mutator -- set value at index to Object,
    //           return old value at index
    public Object set( int index, Object o )
    {
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("invalid index input");
	}
	else{
	    Object temp = _data[index];
	    _data[index] = o;
	    return temp;
	}
    }

    
    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    //returns the item removed
    public Object remove( int index )
    {
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("invalid index input");
	}
	else{
	    Object temp = _data[index];
	    for( int i = index;
		 i < _size - 1;
		 i++ ) {
		_data[i] = _data[i+1];
	    }
	    _size--;
	    return temp;
	}
    }
    

    //main method for testing
    public static void main( String[] args )
    {
	List mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);// []

	System.out.println( mayfield.add("five") );// true
	System.out.println( mayfield.add(4) );// true
	System.out.println( mayfield.add("three") );// true
	System.out.println( mayfield.add(2) );// true
	System.out.println( mayfield.add("one") );// true

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);// [five,4,three,2,one]

	System.out.println( mayfield.remove(3) ); // 2
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);// [five,4,three,one]
	System.out.println( mayfield.remove(3) );// one
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);// [five,4,three]

	mayfield.add(3,"blast");
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);// [five,4,three,blast]
	mayfield.add(2,"off");
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);// [five,4,off,three,blast]
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);// [five,77,4,off,three,blast]

	
	  
    }//end main()


}//end class
