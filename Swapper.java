//Sophia Xia
//APCS1 pd1
//HW40 -- Make it Better
//2017-11-21

/*=======================================================================
Version 1:
First prints out the array. Then prompts the user for inputs 4 times.
It should be the row and column for the first String, then the row and
column for the second string. After that the two Strings will swap
places and the array will be printed out again.
=======================================================================*/

/* Version 2:
The columns and rows of the array are now labeled to make the program
more user friendly.
The user can now choose to continue swapping.
 */

import cs1.Keyboard;

public class Swapper{

    //InstVars
    private static int row1;
    private static int col1;
    private static int row2;
    private static int col2;
    
    //PRINT
    //Augmented from TwoDimArray.java
    //only changed the params
    public static void print1( String[][] a ){
	for (int Ctra = 0;
	     a.length > Ctra;
	     Ctra ++){
	    System.out.print(Ctra + "\t");
	    for (int Ctrb = 0;
		 a[Ctra].length > Ctrb;
		 //a[Ctra] instead of 0, covers arrays that aren't rectangles
		 Ctrb ++){
		System.out.print(a[Ctra][Ctrb] + "\t");
	    }
	    System.out.println();
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
	holder = anArray[row1][col1];
	anArray[row1][col1] = anArray[row2][col2];
	anArray[row2][col2] = holder;
    }

    //BEGIN
    public static void swapping(String[][]array){
	//Prompts
	//wasn't sure where to put this so I referenced YoRPG.java
	//for a better idea as to how to structure this
	//Code is kind of repetitive and also using inst vars which I dislike
	//Thought about making the input a String but that seemed
	//more complicated to code

	System.out.println("Note that you start counting rows and columns at 0 instead of 1");
<<<<<<< HEAD
	System.out.println("Please input the location of the strings based on row and then column.\nExample: 0,1-2,3");
	String input = Keyboard.readString();
	row1 = Integer.parseInt(input.substring(0,1));
	col1 = Integer.parseInt(input.substring(2,3));
	row2 = Integer.parseInt(input.substring(4,5));
	col2 = Integer.parseInt(input.substring(6,7));
=======

	//Change to one input prompt
>>>>>>> 0bb0b337c08d5895eba6aa423c41f0428d2066a1
	
	//Swap
	swap(array);
	
	//Print array
	System.out.println("\n\t0\t1\t2");
	print1(array);
    }

    public static void continueSwapping(String[][]array){
	//Prompts
	System.out.println("Note that you start counting rows and columns at 0 instead of 1");
	System.out.println("Please input the location of the strings based on row and then column.\nNote that you have a range of 0 to 3.\nExample: 0,1-2,3");
	String input = Keyboard.readString();
	row1 = Integer.parseInt(input.substring(0,1));
	col1 = Integer.parseInt(input.substring(2,3));
	row2 = Integer.parseInt(input.substring(4,5));
	col2 = Integer.parseInt(input.substring(6,7));
	
	//Swap
	swap(array);
	
	//Print array
	System.out.println("\n\t0\t1\t2");
	print1(array);

<<<<<<< HEAD
	//Continue:
	System.out.println("Continue Swapping? \n1 Yes \t 2 No");

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
	System.out.println("\n\t0\t1\t2");
	print1(array);
	
	swapping(array);
	System.out.println("Continue Swapping? \n1 Yes \t 2 No");
	while(Keyboard.readInt() == 1){
	    continueSwapping(array);
	}
	System.out.println("Exiting...");
	
=======
	//Create a while loop that allows the user to choose whether or not to continue swapping?
>>>>>>> 0bb0b337c08d5895eba6aa423c41f0428d2066a1
    }
}
