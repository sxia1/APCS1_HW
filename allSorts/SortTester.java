//Team Grapefruit
//Roster: James Huang, Sophia Xia
//APCS1 pd1
//HW54 -- One File to Bring Them All...
//2017-12-13

import java.util.ArrayList;

public class SortTester {

    //Main Method
    public static void main(String[] args) {
	//efficient coding calls for Ctr- , M-w, Ctr-y, and M-%
	
	//--------------------BUBBLESORT TEST--------------------
	System.out.println("Testing bubbleSort...");
	ArrayList bob = new ArrayList<Integer>();
	bob.add(7);
	bob.add(1);
	bob.add(5);
	bob.add(12);
	bob.add(3);
	System.out.println( "ArrayList bob before sorting:\n" + bob );
	MySorts.bubbleSortV(bob);
	System.out.println( "ArrayList bob after sorting:\n" + bob );

	ArrayList bobatea = MySorts.populate( 10, 1, 1000 );
	System.out.println( "ArrayList bobatea before sorting:\n" + bobatea );
	MySorts.bubbleSortV(bobatea);
	System.out.println( "ArrayList bobatea after sorting:\n" + bobatea );

	
	//--------------------SELECTION SORT--------------------
	System.out.println("Testing selectionSort...");
	ArrayList stacey = new ArrayList<Integer>();
	stacey.add(7);
	stacey.add(1);
	stacey.add(5);
	stacey.add(12);
	stacey.add(3);
	System.out.println( "ArrayList stacey before sorting:\n" + stacey );
	MySorts.selectionSortV(stacey);
	System.out.println( "ArrayList stacey after sorting:\n" + stacey );
	
	ArrayList sugar = MySorts.populate( 10, 1, 1000 );
	System.out.println( "ArrayList sugar before sorting:\n" + sugar );
	MySorts.selectionSortV(sugar);
	System.out.println( "ArrayList sugar after sorting:\n" + sugar );

	ArrayList species = new ArrayList<Integer>();
	species.add(7);
	species.add(1);
	species.add(5);
	species.add(12);
	species.add(3);
	System.out.println( "ArrayList species before sorting:\n" + species );
	MySorts.selectionSortV(species);
	System.out.println( "ArrayList species after sorting:\n" + species );
	

	
	//--------------------INSERTION SORT--------------------
	System.out.println("Testing insertionSort...");
	ArrayList irene = new ArrayList<Integer>();
	irene.add(7);
	irene.add(1);
	irene.add(5);
	irene.add(12);
	irene.add(3);
	System.out.println( "ArrayList irene before sorting:\n" + irene );
	MySorts.insertionSortV(irene);
	System.out.println( "ArrayList irene after sorting:\n" + irene );

	ArrayList icing = MySorts.populate( 10, 1, 1000 );
	System.out.println( "ArrayList icing before sorting:\n" + icing );
	MySorts.insertionSortV(icing);
	System.out.println( "ArrayList icing after sorting:\n" + icing );

    }//end main
    
}//end class SortTester.java
