//Sophia Xia
//APCS1 pd1
//HW36 -- Be Rational
//2017-11-17

public class Rational{

    //INSTANCE VARS
    private int numer;
    private int denom;

    //DEFAULT CONS
    public Rational(){
	numer = 0;
	denom = 1;
    }

    //CONS
    public Rational(int a, int b){
	if (b == 0){
	    //pretty sure there is a way to call the default cons...
	    //whelp I forgot :P
	    //For now this will do until I remember. I mean... it works
	    numer = 0;
	    denom = 1;
	    System.out.println("Invalid inputs");
	}
	else {
	    numer = a;
	    denom = b;
	}
    }

    //TOSTRING
    public String toString(){
	return numer + "/" + denom;
    }

    //floatValue
    public float floatValue(){
	/*
	 *QAF gave me the idea to mult by 0.1
	 *without 1.0 * , the result is always 0
	 *must have to do with int division truncating
	 *then it said double to float problem?
	 *so I typecasted
	 */
	return (float)(1.0 * numer/denom);
    }

    //multiply
    public void multiply(Rational a){
	//couldn't figure out how to set the Rational object itself
	//so I figured that I should set the instance vars instead
	//is there a way to call the object Rational?
	//I think my language is a little iffy there though...
	numer = (numer * a.numer);
	denom =	(denom * a.denom);
    }
    
    //divide
    public void divide(Rational a){
	//to divide fractions, actually you can multiply :)
	//so same as multiply but apply keep, change, flip
	numer = (numer * a.denom);
	denom =	(denom * a.numer);
    }
    
    //MAIN METHOD
    public static void main(String [] args){
	Rational r = new Rational(2, 3);
	Rational s = new Rational(1, 2);
	System.out.println(r);// 2/3
	System.out.println(s);// 1/2
	System.out.println( r.floatValue() );//0.6666667
	System.out.println( s.floatValue() );//0.5
	r.multiply(s);
	System.out.println(r);// 2/6
	System.out.println(s);// 1/2
	r.divide(s);
	System.out.println(r);// 4/6
	System.out.println(s);// 1/2
	//works however, does not return a simplified version...
    }
}
