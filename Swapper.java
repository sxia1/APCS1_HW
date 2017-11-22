//Sophia Xia
//APCS1 pd1
//HW38 -- Put it Together
//2017-11-21

/* First prints out the array. Then prompts the user for inputs 4 times. It should be the row and column for the first String, then the row and column for the second string. After that the two Strings will swap places and the array will be printed out again.
 */

import cs1.Keyboard;

public class Swapper{

    //InstVars
    private static int a;
    private static int b;
    private static int c;
    private static int d;
    
    //PRINT
    //Augmented from TwoDimArray.java
    //only changed the params
    public static void print1( String[][] a ){
	for (int Ctra = 0;
	     a.length > Ctra;
	     Ctra ++){
	    for (int Ctrb = 0;
		 a[Ctra].length > Ctrb;
		 //a[Ctra] instead of 0, covers arrays that aren't rectangles
		 Ctrb ++){
		System.out.print(a[Ctra][Ctrb] + " ");
	    }
	    System.out.println();
	    //makes new line after array at Ctra is printed before moving onto Ctra ++
	}
    }//end print1
    
    //SWAP
    public static void swap(String[][]anArray){
	String holder = "";
	//remember order matters with the equals
	//spent a while trying to figure out why the Strings didn't swap correctly
	//it was because I set the index to holder instead of the holder to index
	holder = anArray[a][b];
	anArray[a][b] = anArray[c][d];
	anArray[c][d] = holder;
    }
    
    //MAIN METHOD
    public static void main(String [] args){
	
	//Create an Array
	//I believe this is correct since every String is unique
	//I don't understand the 3-4 char limitation though
	//it made me write "spoon" as "spon" and "knife" as "knif" T^T
	//the different themes just make it easier for me to check the results
	//of my testing
	String [][] array = { {"one", "two", "tres"},//numbers
			      {"blue", "red", "pink"},//colors
			      {"knif", "fork", "spon"} };//utensils
	
	//Print array
	print1(array);

	//Prompts
	//wasn't sure where to put this so I referenced YoRPG.java
	//for a better idea as to how to structure this
	//Code is kind of repetitive and also using inst vars which I dislike
	//Thought about making the input a String but that seemed
	//more complicated to code

	System.out.println("Note that you start counting rows and columns at 0 instead of 1");
	
	System.out.println("Input row of first String to swap");
	a = Keyboard.readInt();

	System.out.println("Input column of first String to swap");
	b = Keyboard.readInt();

	System.out.println("Input row of second String to swap");
	c = Keyboard.readInt();

	System.out.println("Input column of second String to swap");
	d = Keyboard.readInt();

	//Swap
	swap(array);
	
	//Print array
	print1(array);

	//perhaps I can create a while loop that allows the user to choose whether or not to continue swapping?
    }
}
