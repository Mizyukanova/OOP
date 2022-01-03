package mypackage;

public class Mod implements IOperation {

	@Override
	public String getSign() {
		return "MOD";
	}
	
	@Override
	public String getName() {
		return "Деление с остатком";
	}
	
	@Override
	public int estimate( int a, int b) {
		return a % b;
	}
}
