package reverseNum;

import java.util.Scanner;

public class reverseNumber {
	Scanner keyboard = new Scanner(System.in);
	int inputnum;
	int initialnum;
	String outputnum="";
	int num = 1;
	int i = 1;
	public String reverse() {
		System.out.println("Input a number to reverse it:");
		inputnum= keyboard.nextInt();
		initialnum=inputnum;
		while(i>0) {
			num=inputnum%10;
			outputnum = outputnum+num;
			inputnum/= 10;;
			if(inputnum == 0) {
				i=0;
			}
		}
		return outputnum;
	}
}
