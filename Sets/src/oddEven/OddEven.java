package oddEven;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class OddEven {
	public static void main(String [] args) {
		Set<String> even = new TreeSet<>();
		Set<String> odd = new TreeSet<>();
		Scanner key = new Scanner(System.in);
		System.out.println("input: ");
		String[] input = key.nextLine().split(" ");
		for(int i = 0; i<input.length;i++) {
			if(Integer.parseInt(input[i]) % 2 == 0) {
				even.add(input[i]);
			}
			else {
				odd.add(input[i]);
			}
		}
		System.out.println("Even: " + even);
		System.out.println("Odd: " + odd);

	}
}
