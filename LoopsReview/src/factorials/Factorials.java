package factorials;

import java.util.Scanner;

public class Factorials {
	Scanner keyboard = new Scanner(System.in);
	int inputNum;
	int outputNum;
	
	public int factorial() {
		System.out.println("input a number to find its factorial: ");
		inputNum = keyboard.nextInt();
		for(int i=inputNum-1; i>0; i--) {
			outputNum = inputNum * i;
		}
		return outputNum;
	}
}
