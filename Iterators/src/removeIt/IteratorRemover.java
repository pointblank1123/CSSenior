package removeIt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class IteratorRemover {
	ArrayList<String> list;
	Iterator<String> it;
	Scanner key = new Scanner(System.in);
	String[] input;
	String remove;
	
	public void Iterate() {
		System.out.println("Input a line of strings:");
		input=key.nextLine().split(" ");
		list = new ArrayList<String>(Arrays.asList(input));
		remove = list.get(list.size()-1);
		it = list.iterator();
		while(it.hasNext()) {
			if(it.next().equals(remove)) {
				it.remove();
			}
		}
		System.out.println(list.toString());
	}
}
