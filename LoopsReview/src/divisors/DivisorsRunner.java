package divisors;

import java.util.ArrayList;

public class DivisorsRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Divisors divisor = new Divisors();
		ArrayList<Integer> returnedNums = new ArrayList<>(divisor.divMethod());
		System.out.print("The Divisors are: ");
		for(int i = 0;i<returnedNums.size() ;i++) {
			System.out.print(returnedNums.get(i)+", ");
		}
	}
}
