//Sophia Xia
//APCS1 pd1
//HW48 -- Keep Guessing
//2017-12-07

import cs1.Keyboard;

public class GuessNumber{

    //Instance Variables
    //without instantiating the value of num...
    //when you run this program, it will keep num at a specific value
    //when I ran the first, second and third time, the correct guess was 22
    //that's how I knew something was off...
    private static int num = 0;
    private static int guess;
    private static int Ctr = 0;
    private static int upb = 100;
    private static int lowb = 1;

    //methods
    //-----------------------------------------------------------------------
    //setNum
    public static void setNum(){
	num = (int)((Math.random()* 100) +1);
    }
    
    //Guessing...
    public static void guess(){
	System.out.print("\nGuess a number from " + lowb + "-" + upb + ": ");
	guess = Keyboard.readInt();
	if (guess > num){
	    Ctr ++;
	    upb = guess - 1;
	    System.out.println("\tToo high, try again...");
	    guess();
	}
	else if (guess < num){
	    Ctr ++;
	    lowb = guess + 1;
	    System.out.println("\tToo low, try again...");
	    guess();
	}
	else if (guess == num){
	    Ctr ++;
	    System.out.println("\tCorrect! It took " + Ctr + " guesses.");
	    newRound();
	}
    }

    //newRound?
    public static void newRound(){
	System.out.print("\nBegin new round of guessing? 1. Yes 2. No : ");
	if (Keyboard.readInt() == 1){
	    guess();
	}
    }
    
    //main method
    //-----------------------------------------------------------------------
    public static void main(String [] args){
	setNum();
	guess();
    }//end main
    
}//end class GuessNumber
