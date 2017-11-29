/***************************
 * Sophia Xia
 * APCS1 pd1
 * HW41 -- Array of Steel
 * 2017-11-27
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray{

    //Started off by refering to Rational.java to get a better idea of what
    //I should be doing starting with the constructors...
    //Good move because before I was kind of lost. Did not want to jump into
    //this with the wrong approach only to realize it much much later.
    //honestly, starting the assignment always takes me the longest T^T
    
    private int[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


    //default constructor – initializes 10-item array
    /* Notes
     * in Rational, the constructor set the inst vars
     * in class my table mate kind of declared a new object?
     * idk it didn't seem right so I checked Rational...
     * I'm not sure why I was confused as to what to do for this one...
     */
    public SuperArray(){
	_size = 10;
	_data = new int[_size];
    }


    //output SuperArray in [a,b,c] format
    /* Notes
     * At first I had an extra comma at the end, so I took the substring of str
     * so it would be 0 to the 2 * _size, however there were problems with that.
     * When printing out the populated array, the code did not work since the
     * it did not consider numbers that weren't single digits.
     * As a result I altered the initiation of str and added the comma first
     * before concatenating the value at the index.
     */
    public String toString(){
	String str = "[" + _data[0];
	for( int Ctr = 1;
	     Ctr != _size;
	     Ctr ++){
	    str = str + "," + _data[Ctr];
	}
	str = str + "]";
	return str;
    }


    //double capacity of SuperArray
    private void expand(){
	//can't do this.length because this refers to the Object SuperArray
	//not the array itself and there isn't a length of an Object
	//preparations: creating vars and setting inst vars
	_size = _size *2;
	int[]_datb;
	_datb = new int[_size];
	//copies values of _data into _datb
	for ( int Ctr = 0;
	      Ctr != _size/2;
	      Ctr ++){
	    _datb[Ctr] = _data[Ctr];
	}
	//sets the inst var to _datb
	_data = _datb;
    }


    //accessor -- return value at specified index
    public int get( int index ){
	return _data[index];
    }


    //mutator -- set value at index to newVal,
    //           return old value at index
    public int set( int index, int newVal ){
	int val = _data[index];
	_data[index] = newVal;
	return val;
    }


    //main method for testing
    public static void main( String[] args )
    {

	//tests toString
	SuperArray curtis = new SuperArray();
	System.out.println( "Printing empty SuperArray curtis..." );
	System.out.println( curtis );// [0,0,0,0,0,0,0,0,0,0]

	//tests set (mutator)
	for( int i = 0;
	     i < curtis._data.length;
	     //curtis._data.length is allowed!!! 0.o
	     i++ ) {
	    curtis.set( i, i * 2 );
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);// [0,2,4,6,8,10,12,14,16,18]


	//tests Expand and get
	//mistake?
	//should the SOP be in the body of the for loop
	//although if it is, it can help show the process of expansion
	for( int i = 0;
	     i < 3;
	     i++ ) {
	    curtis.expand();
	    System.out.println("Printing expanded SuperArray curtis...");
	    System.out.println(curtis);
	}
	//doubled length of array 3 times so it should be 8 times as long
	// [0,2,4,6,8,10,12,14,16,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	// ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
	// 0,0,0,0,0,0,0,0,0,0,0,0,0,0]
	
    }//end main()


}//end class
