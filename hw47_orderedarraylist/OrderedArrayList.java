//Sophia Xia
//APCS1 pd1
//HW47 -- ascending
//2017-12-05

import java.util.ArrayList;

public class OrderedArrayList{

    //sorted FOR LOOP
    //determines whether or not the array is sorted
    //pulled from ALTester
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
    
    //sortstep FOR LOOP
    //will make each element determine where they should be in comparison
    //to their neighbor to the right
    public static void sortstep(ArrayList<Comparable> aL){
	for(int i = 0;
	    i <= aL.size() -2;
	    i++){
	    if (aL.get(i).compareTo(aL.get(i+1)) > 0){
		//MUST declare temp as a Comparable NOT as an object!!!
		Comparable temp = aL.get(i);
		aL.set(i, aL.get(i+1));
		aL.set(i+1, temp);
	    }
	}
    }
     
    //sort WHILE LOOP
    //will continue calling sortstep until the entire array is sorted
    public static void sort(ArrayList<Comparable> ArrayList){
	while( !sorted(ArrayList) ){
	    sortstep(ArrayList);
	}
    }
    
    //main method
    public static void main(String [] args){
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
	sort(shiboh);
	System.out.println(shiboh);
	
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
	sort(remi);
	System.out.println(remi);
	
	ArrayList<Comparable> aeryl = new ArrayList<Comparable>();
	System.out.println(aeryl);// []
	for(int i = 0;
	    i <= 22;
	    i ++){
	    aeryl.add(10);
	}
	System.out.println(aeryl);// [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
	System.out.println(aeryl.size());// 23
	System.out.println(sorted(aeryl));// true
	sort(aeryl);
	System.out.println(aeryl);
	
    }//end main
    
}//end class OrderedArrayList
