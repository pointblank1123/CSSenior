package divisors;
import java.util.ArrayList;
import java.util.Scanner;

public class Divisors {
	Scanner keyboard = new Scanner(System.in);
	int num;
	int divisorTest;
	public ArrayList<Integer> divMethod() {
		System.out.print("Input a number to find is divisors: ");
		num = keyboard.nextInt();
		divisorTest = 1;
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		while(divisorTest < num) {
			if(num%divisorTest == 0) {
				divisors.add(divisorTest);
				divisorTest += 1;
			}
			else {
				divisorTest+=1;
			}
		}
		return divisors;
	}
}