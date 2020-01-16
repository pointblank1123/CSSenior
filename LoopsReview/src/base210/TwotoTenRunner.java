package base210;

public class TwotoTenRunner {
	public static void main(String[] args) {
		TwotoTen convert = new TwotoTen();
		double base10 = convert.converter();
		System.out.println("The base 10 value of " + convert.base2Init + " is: " + base10);
	}
}

