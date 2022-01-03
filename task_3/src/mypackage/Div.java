package mypackage;

public class Div implements IOperation {
	
	@Override
	public String getSign() {
		return "DIV";
	}
	
	@Override
	public String getName() {
		return "Деление нацело";
	}
	
	@Override
	public int estimate( int a, int b) {
		return a / b;
	}
}
