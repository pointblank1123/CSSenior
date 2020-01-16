package replaceIt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;

public class IteratorReplacer {
	ArrayList<String> list;
	ListIterator<String> it;
	Scanner key = new Scanner(System.in);
	String[] input;
	String remove;
	String replace;
	
	public void Replace() {
		System.out.println("Input a line of strings:");
		input=key.nextLine().split(" ");
		list = new ArrayList<String>(Arrays.asList(input));
		remove = list.get(list.size()-2);
		replace = list.get(list.size()-1);
		it = list.listIterator();
		while(it.hasNext()) {
			if(it.next().equals(remove)) {
				it.previous();
				it.set(replace);
			}
		}
		list.remove(list.size()-2);
		list.remove(list.size()-1);
		System.out.println(list.toString());
	}
}
