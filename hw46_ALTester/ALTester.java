//Sophia Xia
//APCS1 pd1
//HW46 -- Al<B> Sorted!
//2017-12-05

import java.util.ArrayList;

public class ALTester{

    //SORTED
    //note that once I added this method, the terminal said:
    //     Note: ALTester.java uses unchecked or unsafe operations.
    //     Note: Recompile with -Xlint:unchecked for details.
    //The code can still be executed though...

    public static boolean sorted(ArrayList<Comparable> test){
	for(int i = 0;
	    i <= test.size() -2;
	    i++){
	    //I think the reason for the note is due to this BE
	    if (test.get(i).compareTo(test.get(i+1)) > 0){
		//if at anypoint it the int is less than the next one
		//just return false and don't bother evaluating the rest
		return false;
	    }
	}
	return true;//true is every single compareTo returned an int >0
    }
    /*WARNING MSSG
      $ javac ALTester.java -Xlint
      ALTester.java:15: warning: [rawtypes] found raw type: Comparable
      public static boolean sorted(ArrayList<Comparable> test){
      ^
      missing type arguments for generic class Comparable<T>
      where T is a type-variable:
      T extends Object declared in interface Comparable
      ALTester.java:20: warning: [unchecked] unchecked call to compareTo(T) as 
      member of the raw type Comparable
      if (test.get(i).compareTo(test.get(i+1)) > 0){
      ^
      missing type arguments for generic class Comparable<T>
      where T is a type-variable:
      T extends Object declared in interface Comparable
      
      took the ones that referred to remi and shiboh as the core of the problem
      is in the BE
    */

    //MAIN METHOD
    public static void main(String [] args){

	//practiced shortcut for find and replace (M-%)
	//getting easier to use and it is actually really convenient ^-^
	//not that I didn't think so before, but practicing makes it even better
	
	ArrayList<Comparable> shiboh = new ArrayList<Comparable>();
	System.out.println(shiboh);// []
	for(int i = 0;
	    i <= 22;
	    i ++){
	    shiboh.add(i);
	}
	System.out.println(shiboh);// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22]
	System.out.println(shiboh.size());// 23
	System.out.println(sorted(shiboh));// true
	
	ArrayList<Comparable> remi = new ArrayList<Comparable>();
	System.out.println(remi);// []
	for(int i = 0;
	    i <= 22;
	    i ++){
	    remi.add((int)(Math.random()*10));
	}
	System.out.println(remi);
	System.out.println(remi.size());// 23
	System.out.println(sorted(remi));// false

	ArrayList<Comparable> aeryl = new ArrayList<Comparable>();
	System.out.println(aeryl);// []
	for(int i = 0;
	    i <= 22;
	    i ++){
	    aeryl.add((int)(Math.random()*10));
	}
	System.out.println(aeryl);
	System.out.println(aeryl.size());// 23
	System.out.println(sorted(aeryl));// false
	
    }//end main
    
}//end class ALTester

