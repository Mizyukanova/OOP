package mypackage;

import java.math.BigInteger;

// Greatest common divisor - Наибольший общий делитель (НОД)
public class Gcd implements IOperation {

	@Override
	public String getSign() {
		return "GCD";
	}
	
	@Override
	public String getName() {
		return "Наибольший общий делитель";
	}
	
	@Override
	public int estimate( int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
	    BigInteger b2 = BigInteger.valueOf(b);
	    BigInteger gcd = b1.gcd(b2);
	    return gcd.intValue();
	}
	
}
