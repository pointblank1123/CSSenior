package uniqueDup;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class UniqueDup {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<>();
		TreeSet<String> comp = new TreeSet<>();
		TreeSet<String> dup = new TreeSet<>();
		Scanner key = new Scanner(System.in);
		System.out.println("Input: ");
		String[] input = key.nextLine().split(" ");
		for(int i =0;i<input.length;i++) {
			a.add(input[i]);
		}
		for(int j=0; j<a.size();j++) {
			if(comp.add(a.get(j))==false) {
				dup.add(a.get(j));
			}
			else {
				comp.add(a.get(j));
			}
		}
		System.out.println("Unique: " + comp);
		System.out.println("Duplicate: " + dup);

	}
}
