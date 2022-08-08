/*Aryan Kedarisetty 
The following program uses object oriented programming components such as classes, constructors, encapsulation etc.
An object type of a fraction is created which will allow users to construct and operate on fractions using the class' methods.
 
*/
public class Fraction {
//declare encapsulated fields
  private int numerator;
  private int denominator;
  
  //constructors 
  public Fraction(int numerator, int denominator) { //sets corresponding fields
    simplifyAndInit(numerator, denominator);

  }

  public Fraction(int wholeNumber) { //sets num to whole number and denom to 1
    this.numerator = wholeNumber;
    this.denominator = 1;

  }

  public Fraction(String f) {
	  // checks symbol before fraction if it is there
    if (f.charAt(0) == '-' || f.charAt(0) == '+') {
      int numerator = Integer.valueOf(f.substring(1, f.indexOf("/")));
      if (f.charAt(0) == '-')
        numerator = 0 - numerator;
      int denominator = Integer.valueOf(f.substring(f.indexOf("/") + 1));
      simplifyAndInit(numerator, denominator);
      
    }
    //converts string substrings into corresponding parts of fraction
    else {
      int numerator = Integer.valueOf(f.substring(0, f.indexOf("/")));
      int denominator = Integer.valueOf(f.substring(f.indexOf("/") + 1));
      simplifyAndInit(numerator, denominator);

    }
    if (denominator == 0) {
      throw new IllegalArgumentException("cannot divide by zero");
    }

  }


  //initialize method that simplifies fraction and used by constructors to set field values
  private void simplifyAndInit(int numerator, int denominator) {
	if (denominator == 0) {
	        throw new IllegalArgumentException("Cannot divide by 0");
	}
    if (denominator < 0 && numerator < 0) { //negative over negative equals positive
      denominator = Math.abs(denominator);
      numerator = Math.abs(numerator);
    }
    if (denominator < 0) { //converts numerator into negative and denominator to positive
      denominator = Math.abs(denominator);
      numerator = 0 - Math.abs(numerator);
    }
    //finds gcd of num and denom to simplify
    int gcf = 0;
    for (int i = Math.max(numerator, denominator); i >= 1; i--) {
      if (Math.abs(numerator) % i == 0 && Math.abs(denominator) % i == 0) {
        gcf = i;
        break;
      }

    }
    //simplifies
    this.numerator = numerator / gcf;
    this.denominator = denominator / gcf;
    
   
  }
  
  //accessor methods
  public int getNumerator() {
	  return numerator;
  }
  public int getDenominator() {
	  return denominator;
  }
  //arithmetic operation methods
  public Fraction multiply(Fraction f) { //multiplies across and creates object in which fraction is simplified
    int num = numerator * f.numerator;
    int den = denominator * f.denominator;
    Fraction result = new Fraction(num, den);
    return result;

  }

  public Fraction divide(Fraction f) {//Flips 2nd fraction and multiplies
    int num = numerator * f.denominator;
    int den = denominator * f.numerator;
    if (den == 0 ) {
        throw new IllegalArgumentException("Message goes here");
    }
    Fraction result = new Fraction(num, den);
    return result;

  }
  
//finds lcm as denominator and multiplies numerators by opposite denominators and adds them
  public Fraction add(Fraction f) {
    int den = f.denominator * denominator;
    int num = (numerator * f.denominator) + (f.numerator * denominator);
    Fraction result = new Fraction(num, den);
    return result;
  }
//finds lcm as denominator and multiplies numerators by opposite denominators and subtracts them
  public Fraction subtract(Fraction f) {
    int den = f.denominator * denominator;
    int num = (numerator * f.denominator) - (f.numerator * denominator);
    Fraction result = new Fraction(num, den);
    return result;
  }
  //converts fraction object to minimal string
  public String toString() {
	  if (denominator == 1) return "" + numerator;
    return numerator + "/" + denominator;

  }
  //converts fraction objext to mixed number string
  public String toMixedNumberString() {
	  //numerator of mixedF is the remainder of num/denom 
	  int num = numerator % denominator;
	  int whole = (numerator - num)/ denominator; //whole equals num-remainder divided by the denominator
	  if (num == 0) return "" + whole;
	  if (Math.abs(numerator) < Math.abs(denominator)) return numerator + "/" + denominator;
	  return whole + "_" + Math.abs(num) + "/" + this.denominator;
  }
  //method to find if a fraction is greater than the other fraction
  public int compareTo(Fraction f) {
	  //converts fractions to double values 
	  if ( (double) numerator/denominator > (double) f.numerator/f.denominator) return 1;
	  else if ( (double) numerator/denominator < (double) f.numerator/f.denominator) return -1;
	  return 0;
	  
  }
}