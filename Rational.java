//Sophia Xia
//APCS1 pd1
//HW36 -- Be Rational
//2017-11-17

public class Rational{

    //INSTANCE VARS
    //convention says use underscore
    private int _numer;
    private int _denom;

    //DEFAULT CONS
    public Rational(){
	_numer = 0;
	_denom = 1;
    }

    //CONS
    public Rational(int a, int b){
	//to call default cons use this(), because it must be the first line make a conditional using b != 0 instead of b == 1
	this();
	if (b != 0){
	    _numer = a;
	    _denom = b;
	}
	else {
	    System.out.println("Invalid inputs");
	}
    }

    //TOSTRING
    public String toString(){
	return _numer + " / " + _denom;
    }

    //floatValue
    public float floatValue(){
	/*
	 *QAF gave me the idea to mult by 1.0
	 *without 1.0 * , the result is always 0.0
	 *must have to do with int division truncating
	 *then it said double to float problem?
	 *so I typecasted
	 *typecasting takes priority over division
	 */
	return (double)_numer/_denom;
    }

    //multiply
    public void multiply(Rational a){
	//couldn't figure out how to set the Rational object itself
	//so I figured that I should set the instance vars instead
	//is there a way to call the object Rational?
	//I think my language is a little iffy there though...
	_numer = (_numer * a._numer);
	_denom = (_denom * a._denom);
    }
    
    //divide
    public void divide(Rational a){
	//to divide fractions, actually you can multiply :)
	//so same as multiply but apply keep, change, flip
	_numer = (_numer * a._denom);
	_denom = (_denom * a._numer);
    }
    //=======================================================================
    //MAX(a b)
    public static int max(int a, int b){
	if (a > b){
	    return (a);
	}
	return (b);
    }
    public static double max(double a, double b){
	if (a > b){
	    return (a);
	}
	return (b);
    }
    
    //add
    //subtract
    //gcd
    //Returns the gcd of the numerator and denominator
    //Uses Euclid's algorithm (reuse your old code!)
    //Recall that in order for Euclid's algorithm to work, the first number must be greater than the second
    public static void gcd(int a, int b){
	
    }
    //reduce
    //compareTo
    
    
    //MAIN METHOD
    public static void main(String [] args){
	Rational r = new Rational(2, 3);
	Rational s = new Rational(1, 2);

	//testing toString
	System.out.println(r);// 2 / 3
	System.out.println(s);// 1 / 2

	//testing floatValue
	System.out.println( r.floatValue() );// 0.6666667
	System.out.println( s.floatValue() );// 0.5

	//testing multiply
	r.multiply(s);
	System.out.println(r);// 2 / 6
	System.out.println(s);// 1 / 2

	//testing divide
	r.divide(s);
	System.out.println(r);// 4 / 6
	System.out.println(s);// 1 / 2
	
    }
}
