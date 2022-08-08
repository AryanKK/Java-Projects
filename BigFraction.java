/*Aryan Kedarisetty 
The following program uses object oriented programming components such as classes, constructors, encapsulation etc.
An object type of a big fraction is created which will allow users to construct and operate on fractions with numerators 
& denominators that exceed the limit of primitive int values (by using BigInteger object) using the class' methods.
 
*/
import java.math.BigInteger;

public class BigFraction {
	//encapsulated fields
	private BigInteger numerator;
	private BigInteger denominator;
  
  //constructors
	public BigFraction(int numerator, int denominator) {
	  BigInteger num = BigInteger.valueOf(numerator);
	  BigInteger denom = BigInteger.valueOf(denominator);
    simplifyAndInit(num, denom);

	}
  
	public BigFraction(BigInteger numerator, BigInteger denominator) {
    simplifyAndInit(numerator, denominator);

	}
	
	public BigFraction(int wholeNumber) {
		numerator =  BigInteger.valueOf(wholeNumber);
		denominator = BigInteger.ONE;

	}
  
	public BigFraction(BigInteger wholeNumber) {
	    numerator =  wholeNumber;
	    denominator = BigInteger.ONE;
	}
  
  // takes String and converts into fraction objects with corresponding parts 
	public BigFraction(String f) {
		if (f.charAt(0) == '-' || f.charAt(0) == '+') {
			BigInteger numerator = new BigInteger(f.substring(1, f.indexOf("/"))); //goes through string and splits
			if (f.charAt(0) == '-') {
				numerator = BigInteger.ZERO.subtract(numerator);
			} 
			BigInteger denominator = new BigInteger(f.substring(f.indexOf("/") + 1));
			simplifyAndInit(numerator, denominator);
      
		}

		else {
			BigInteger numerator = new BigInteger(f.substring(0, f.indexOf("/")));
			BigInteger denominator = new BigInteger(f.substring(f.indexOf("/") + 1));
			simplifyAndInit(numerator, denominator);

		}
		if (denominator == BigInteger.ZERO) {
			throw new IllegalArgumentException("cannot divide by zero");
		}
    
    

	}
  //local method that will simplify and initialize fractions with BigIntegers
	private void simplifyAndInit(BigInteger numerator, BigInteger denominator) {
	 

    //checks to convert fraction into proper form
		if (denominator.equals(BigInteger.ZERO)) {
	        throw new IllegalArgumentException("Cannot divide by 0");
		}
		if (denominator.compareTo(BigInteger.ZERO) == -1 && numerator.compareTo(BigInteger.ZERO) == -1) {
			denominator = denominator.abs();
			numerator = numerator.abs();
		}
		if (denominator.compareTo(BigInteger.ZERO) == -1) {
			denominator = denominator.abs();
			numerator = BigInteger.ZERO.subtract(numerator.abs());
		}
    
		BigInteger gcf = (numerator.gcd(denominator)); //finding gcd to simplify (luckily BigInteger has a method)
		this.numerator = numerator.divide(gcf);
		this.denominator = denominator.divide(gcf);

	}
  
  //accessor methods
	public BigInteger getNumerator() {
		return this.numerator;
	}
  
	public BigInteger getDenominator() {
		return this.denominator;
	}
  
  //arithmetic operations, uses almost same logic as Fraction class methods
	public BigFraction multiply(BigFraction f) {
		BigInteger num = numerator.multiply(f.numerator);
		BigInteger den = denominator.multiply(f.denominator);
		BigFraction result = new BigFraction(num, den);
		return result;
		
	}
	//uses reciprocal multiplication and checks if denom != 0
	public BigFraction divide(BigFraction f) {
		BigInteger num = numerator.multiply(f.denominator);
		//just multiplies reciprocal
		BigInteger den = denominator.multiply(f.numerator); 
    
		if (den.equals(BigInteger.ZERO)) {
    		throw new IllegalArgumentException("Cannot divide by 0");
		}
		BigFraction result = new BigFraction(num, den);
		return result;

	}
	//uses lcm for denominator and numerators are multiplied by it and added together
	public BigFraction add(BigFraction f) {
	  BigInteger den = denominator.multiply(f.denominator);
	  BigInteger num = (numerator.multiply(f.denominator)).add((f.numerator.multiply(denominator)));
	  BigFraction result = new BigFraction(num, den);
	  return result;
	}
	//uses lcm for denominator and numerators are multiplied by it and subtracted
	public BigFraction subtract(BigFraction f) { 
		BigInteger den = denominator.multiply(f.denominator);
		BigInteger num = (numerator.multiply(f.denominator)).subtract((f.numerator.multiply(denominator)));;
		BigFraction result = new BigFraction(num, den);
		return result;
	}
  
//converts fractions into string, same logic as Fraction
	public String toString() {
		if (denominator.equals(BigInteger.valueOf(1))) return "" + numerator;
		return numerator + "/" + denominator;

	}
  
  //converts into mixed number by determining whole number and numerator
	public String toMixedNumberString() {
		BigInteger num = numerator.abs().mod(denominator);
		BigInteger whole = numerator.divide(denominator);
		if (num.equals(BigInteger.ZERO)) return "" + whole;
		if (numerator.abs().compareTo(denominator.abs()) == -1) return numerator + "/" + denominator;
		return whole + "_" + num.abs() + "/" + denominator;
	}
  
  //to determine if one fraction is greater than the other, converts value into double to check actual decimal value of fractions
	public int compareTo (BigFraction f) {
		if (numerator.doubleValue()/(denominator).doubleValue() > (f.numerator.doubleValue()/(f.denominator.doubleValue()))) return 1;
		else if (numerator.doubleValue()/(denominator).doubleValue() < (f.numerator.doubleValue()/(f.denominator.doubleValue()))) return -1;
		return 0;
	  
	}
  
  
}