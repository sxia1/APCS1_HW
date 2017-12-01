// Team Highlighters
// Roster: Sophia Xia, Qian Zhou
// APCS1 pd1
// HW44 -- Rational Equality
// 2017-11-30

/******************************
 * class Rational v.3
 * (SKELETON)
 * stores a rational number (p/q s.t. p,q ints && q!=0)
 * facilitates
 * multiplication
 * division
 * addition
 * subtraction
 * reduction
 * comparison
 ******************************/

// Clyde "Thluffy" Sinclair
// APCS1 p0
// HW44 -- implementing an interface, boolean short-circuiting
// 2017-12-01

public class Rational
{
    //   Instance variables for the numerator and denominator
    private int _numerator;
    private int _denominator;


    // Default constructor (no parameters)
    // creates a new Rational with the value of 0/1
    public Rational()
    {
	_numerator = 0;
	_denominator = 1;
    }


    // Constructor
    // takes 2 parameters, one for the numerator, one for the denominator
    // if an invalid denominator is attempted, should print a message and set the number to 0/1
    public Rational( int n, int d )
    {
	this();
	if ( d != 0 ) {
	    _numerator = n;
	    _denominator = d;
	}
	else {
	    System.out.println( "Invalid number. " +
				"Denominator set to 1." );
	}
    }


    // toString
    // returns a string representation of the rational number (formatting of your choice)
    public String toString()
    {
	return _numerator + " / " + _denominator;
    }


    // floatValue
    // returns floating point approximation of the number
    // uses the most precise floating point primitive
    public double floatValue()
    {
	return (double)_numerator / _denominator;
    }


    // multiply
    // takes a Rational parameter and multiplies it by this Rational
    // does not return a value
    // modifies this object, leaves parameter alone
    // need not reduce
    public void multiply( Rational r )
    {
	_numerator   = this._numerator   * r._numerator;
	_denominator = this._denominator * r._denominator;
    }


    // divide
    // works the same as multiply, except the operation is division
    public void divide( Rational r )
    {
	if ( r._numerator != 0 ) {
	    _numerator   = _numerator   * r._denominator;
	    _denominator = _denominator * r._numerator;
	}
	else {
	    System.out.println( "Div by 0 error. Values unchanged." );
	}
    }


    //increases this Rational by value of input Rational
    public void add( Rational r )
    {
	_numerator = _numerator * r._denominator + r._numerator * _denominator;
	_denominator = _denominator * r._denominator;
    }


    //decreases this Rational by value of input Rational
    public void subtract( Rational r )
    {
	_numerator = _numerator * r._denominator - r._numerator * _denominator;
	_denominator = _denominator * r._denominator;
    }


    //reduces this Rational to simplest fraction
    public void reduce()
    {
	int g = gcd();
	_numerator = _numerator / g;
	_denominator = _denominator / g;
    }


    //calculates GCD/GCF of numerator and denominator
    public int gcd()
    {
	return gcd( _numerator, _denominator );
    }


    //calculates GCD/GCF of two int inputs
    public static int gcd( int n, int d )
    {
	int a, b, x;

	a = n;
	b = d;

	while( a % b != 0 ) {
	    x = a;
	    a = b;
	    b = x % b;
	}

	return b;
    }


    /*********************
     * boolean equals(Object) -- tells whether 2 Objs are equivalent
     * pre:  other is an instance of class Rational
     * post: Returns true if this and other are aliases (pointers to same
     *   Object), or if this and other have matching attribute values.
     *   (which in this case indicates equivalent fractions)
     *********************/
    public boolean equals( Object other )
    {
	//First, reduce both fractions.
	//...thus allowing for direct comparison of attributes
	reduce();
	if(other instanceof Rational){
	    return (compareTo(other) == 0);
	}
	return false;
    }//end equals()


    /*********************
     * int compareTo(Object) -- tell which of two Rationals is greater
     *  pre:
     *  post: Throw exception if input not an instance of class Rational.
     *    Return 0 if this Rational equiv to Rational argument.
     *    Return negative integer if this < other.
     *    Return positive integer if this > other.
     *********************/
    public int compareTo( Object other )
    {
	// If other is not a Rational, throw an exception
	if(!(other instanceof Rational)){
	    throw new ClassCastException ("Invalid input");
	}
	// This will exit the function, generating a runtime error
	else{
	    //typecasting requires parantheses due to priority issues
	    return (this._numerator*((Rational)other)._denominator)-
		(((Rational)other)._numerator*this._denominator);
	}     
    }


    //main method for testing
    public static void main( String[] args )
    {
	Rational r = new Rational( 3, 7 );
	Rational s = new Rational();
	Rational t = new Rational( 8, 5 );

	Rational u = new Rational( 1, 2 );
	Rational v = new Rational( 2, 3 );
	Rational w = new Rational( 8, 12 );

	Rational x = new Rational( 8, 12 );
	String y = "yoo";

	System.out.println("r: " + r ); // r: 3 / 7
	System.out.println("s: " +  s ); // s: 0 / 1
	System.out.println("t: " +  t ); // t: 8 / 5

	//Test floatValue
	System.out.println( r + " as a floating pt approximation: "
			    + r.floatValue() ); // 0.42857142857142855 
	System.out.println( s + " as a floating pt approximation: "
			    + s.floatValue() ); // 0.0
	System.out.println( t + " as a floating pt approximation: "
			    + t.floatValue() ); // 1.6

	//Test multiply, divide, add, and subtract
	System.out.print( r + " * " + t + " = ");
	r.multiply(t);
	System.out.println(r); // 24 / 35

	System.out.print( r + " / " + t + " = ");
	r.divide(t);
	System.out.println(r); // 120 / 280

	System.out.print( u + " + " + v + " = ");
	u.add(v);
	System.out.println(u); // 7 / 6

	System.out.print( u + " - " + v + " = ");
	u.subtract(v);
	System.out.println(u); // 9 / 18

	//Test static gcd
	System.out.println( "\nNow testing static gcd...");
	System.out.println("expect 1");
	System.out.print("actual:\t");
	System.out.println( Rational.gcd(100,9) ); // 1

	System.out.println("expect 5");
	System.out.print("actual:\t");
	System.out.println( Rational.gcd(245,25) ); // 5


	//Test non-static gcd
	System.out.println( "\nNow testing non-static gcd...");
	System.out.println("Rational r...");
	System.out.println( r ); // 120 / 280
	System.out.println("expect 40");
	System.out.print("actual:\t");
	System.out.println( r.gcd() ); // 40

	System.out.println("Rational t...");
	System.out.println( t ); // 8 / 5
	System.out.println("expect 1");
	System.out.print("actual:\t");
	System.out.println( t.gcd() ); // 1

	System.out.println("Rational w...");
	System.out.println( w ); // 8 / 12
	System.out.println("expect 4");
	System.out.print("actual:\t");
	System.out.println( w.gcd() ); // 4


	//Test Reduce
	System.out.println( "\nNow testing reduce...");
	System.out.println("Rational r...");
	System.out.println( r ); // 120 / 280
	System.out.print( r + " in reduced form = ");
	r.reduce();
	System.out.println(r); // 3 / 7
	

	//Test compareTo
	System.out.println( "r > t: " +  r.compareTo(t) ); // -41
	System.out.println( "r > s: " +  r.compareTo(s) ); // 3
	System.out.println( "s > t: " +  s.compareTo(t) ); // -8
	System.out.println( "v > w: " +  v.compareTo(w) ); // 0
	System.out.println( "w > x: " +  w.compareTo(x) ); // 0
	
	//uncommenting the line below should trigger a runtime error
	//System.out.println( "s > y: " +  s.compareTo(y) );
	//Exception in thread "main" java.lang.ClassCastException: Invalid input

	//Test equals
	System.out.println( "v.equals(v): " + v.equals(v) ); // true
	System.out.println( "v.equals(w): " + v.equals(w) ); // true
	System.out.println( "w.equals(x): " + w.equals(x) ); // true
	System.out.println( "w.equals(s): " + w.equals(s) ); // false
	System.out.println( "w.equals(y): " + w.equals(y) ); // false
	/*~~~v~~~~~~~~~~down~goer~3~~~~~~~~~~~~~v~~~~~
	  ~~~~~|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~*/
    }

}//end class
