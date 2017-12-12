//Sophia Xia
//APCS1 pd1
//HW51 -- Selection
//2017-12-11

//NOTE TO SELF:
//sometimes it might help to break down the algo into parts
//then decide the fastest and most concise way to code each part
//also DO NOT try to use past hws with completely different concepts
//AKA bubbler: same goal, but VERY different ways to reach it
//DO NOT try to cop paste and modify
//works in some cases, NOT this one T^T

/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

import java.util.ArrayList;

public class SelectionSort 
{
    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
	//rewrote this code, because the first time it straight up did not work
	//it was long and irritating, so I got rid of all of it
	//shoutout to Thet for helping me troubleshoot and being patient T^T
	int Ctr = 0;
	while(Ctr < data.size() -1){
	    //find smallest index
	    int smallesti = Ctr;
	    for(int i = Ctr;
		i < data.size();
		i++){
		if(data.get(smallesti).compareTo(data.get(i)) > 0){
		    smallesti = i;
		}
	    }
	    //swap
	    Comparable temp = data.get(smallesti);
	    data.set(smallesti, data.get(Ctr));
	    data.set(Ctr, temp);
	    Ctr++;
	}
    }//end selectionSortV


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable>
	selectionSort( ArrayList<Comparable> input )
      {
	  //doesn't change the input itself
	  //selectionSort(input) and printing input will print unsorted input
	  //printing selectionSort(input) will print the sorted version
	  ArrayList<Comparable> foo = new ArrayList<Comparable>();
	  for( Comparable c: input)
	      foo.add(c);
	  selectionSortV(foo);
	  return foo;
      }//end selectionSort 


    public static void main( String [] args ) 
    {
	/*===============for VOID methods=============	 
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	selectionSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	selectionSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	  ============================================*/

	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  ArrayList glenSorted = selectionSort( glen );
	  System.out.println( "sorted version of ArrayList glen:\n" 
	  + glenSorted );
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  ArrayList cocoSorted = selectionSort( coco );//sorted
	  System.out.println( "sorted version of ArrayList coco:\n" 
			      + cocoSorted );//unsorted
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  System.out.println( coco );//unsorted
	/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class SelectionSort
