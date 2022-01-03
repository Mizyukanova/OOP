package mypackage;

import java.math.BigInteger;

//Least common multiple - Наименьшее общее кратное (НОК)
public class Lcm implements IOperation {

	@Override
	public String getSign() {
		return "LCM";
	}
	
	@Override
	public String getName() {
		return "Наименьшее общее кратное";
	}
	
	@Override
	public int estimate( int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
	    BigInteger b2 = BigInteger.valueOf(b);
	    BigInteger gcd = b1.gcd(b2);
	    BigInteger lcm = b1.multiply(b2).divide(gcd);
		return lcm.intValue();
	}
}
