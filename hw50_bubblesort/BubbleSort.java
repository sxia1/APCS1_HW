//Sophia Xia
//APCS1 pd1
//HW50 -- Dat Bubbly Tho
//2017-12-09

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/

import java.util.ArrayList;

public class BubbleSort {

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
	//setup for traversal fr right to left
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ){
	int Ctr = 0;
	//bubble sort algo always gets job done after size()-1 number of passes
	//no need to write and call a method to see if the array is sorted
	while(Ctr < data.size()-1){
	    Ctr ++;
	    //for loop evals from right to left
	    for(int i = data.size()-1;
		i >=  1;
		i --){
		//compares the element to the one at its left
		//if it is smaller than the one at its left...
		if (data.get(i).compareTo(data.get(i-1)) < 0){
		    //they swap places :D
		    //must declare temp as Comparable!!!
		    Comparable temp = data.get(i);
		    data.set(i, data.get(i -1));
		    data.set(i-1, temp);
		}
	    }//end for loop
	}//end while loop
    }//end bubbleSortV


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
    {
	//didn't feel like copying and pasting code so I just called bubbleSortV
	bubbleSortV(input);
	return input;
    }


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
	  //[7, 1, 5, 12, 3]
	  bubbleSortV(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );
	  //[1, 3, 5, 7, 12]
      
	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  //[503, 992, 13, 288, 111, 465, 830, 870, 96, 871]
	  bubbleSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  //[13, 96, 111, 288, 465, 503, 830, 870, 871, 992]
      
	  ============================================*/

	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	//[7, 1, 5, 12, 3]
	ArrayList glenSorted = bubbleSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
			    + glenSorted );
	//[1, 3, 4, 7, 12]
	System.out.println( "ArrayList glen after sorting:\n" + glen );
	//[1, 3, 4, 7, 12]
	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	//[889, 912, 310, 697, 341, 117, 140, 763, 981, 182]
	ArrayList cocoSorted = bubbleSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	//[117, 140, 182, 310, 341, 697, 763, 889, 912, 981]
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	//[117, 140, 182, 310, 341, 697, 763, 889, 912, 981]
	System.out.println( coco );
	//[117, 140, 182, 310, 341, 697, 763, 889, 912, 981]
	/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class BubbleSort
