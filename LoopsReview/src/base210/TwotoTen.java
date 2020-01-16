package base210;

import java.util.Scanner;

public class TwotoTen {
	Scanner keyboard= new Scanner(System.in);
	long base2;
	long base2Init;
	double	base10;
	int length;
	public double converter() {
		System.out.println("Input a binary number to convert to base 10");
		base2 = keyboard.nextLong();
		base2Init=base2;
		length = String.valueOf(base2).length();
		base10=0;
		for(double i=0;i<length;i++) {
			base10+=base2%10*Math.pow(2,i);
			System.out.println(base2%10);
			System.out.println(Math.pow(2,i));
			System.out.println(base2%10*Math.pow(2,i));
			base2 /= 10;
		}
		return base10;
	}
}
