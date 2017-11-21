//Sophia Xia
//APCS1 pd1
//HW37 -- Be More Rational
//2017-11-20

public class Rational{

    //INSTANCE VARS
    //convention: use underscore
    private int _numer;
    private int _denom;

    //DEFAULT CONS
    public Rational(){
	_numer = 0;
	_denom = 1;
    }

    //OVERLOADED CONS
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
	 *typecasting takes priority over division
	 */
	return (float)_numer/_denom;
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
    
    //=========================================================================
    
    //add
    //writing this out on paper with variables instead of numbers helped a lot
    //using numerical examples just confused me more XD
    public void add(Rational a){
	_numer = (_numer * a._denom) + (a._numer * _denom);
	_denom = (_denom * a._denom);
    }
    
    //subtract
    //copied from add but switched + to -
    public void subtract(Rational a){
	_numer = (_numer * a._denom) - (a._numer * _denom);
	_denom = (_denom * a._denom);
    }
    
    //STATIC gcd
    //Returns the gcd of the numerator and denominator
    //Uses Euclid's algorithm (reuse your old code!)
    //Recall that in order for Euclid's algorithm to work, the first number must be greater than the second
    public static int gcd(int a, int b){
	//note to self: this recursive method takes care of the max min problem
	//rmbr? you had to explain it? in front of the class? and you traced it?
	if (a % b == 0){
	    return b;}
	return gcd (b, a%b);
    }
    
    //gcd
    //idea came from QAF, less coding :)
    public int gcd(){
	return gcd(_numer, _denom);
    }

    
    //reduce
    public void reduce(){
	int holdgcd = gcd(_numer, _denom);
	_numer = _numer / holdgcd;
	_denom = _denom / holdgcd;
    }
    
    //compareTo
    public int compareTo(Rational a){
	if (this.floatValue() == a.floatValue()){
	    return 0;
	}
	else if (this.floatValue() > a.floatValue()){
	    return 1;
	}
	else{
	    return -1;
	}
    }
    
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

	//testing gcd
	System.out.println(r.gcd());//2
	System.out.println(s.gcd());//1
	
	//testing reduce
	r.reduce();
	System.out.println(r);// 2 / 3
	s.reduce();
	System.out.println(s);// 1 / 2

	//testing add/subtract
	//note: these methods do not reduce the fraction
	r.add(s);
	System.out.println(r);// 7 / 6
	r.subtract(s);
	System.out.println(r);// 8 / 12

	//testing compareTo
	System.out.println( r.compareTo(s) ); // 1
	System.out.println( s.compareTo(r) ); //-1
    }
}
