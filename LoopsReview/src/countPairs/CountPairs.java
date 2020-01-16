package countPairs;

import java.util.Scanner;

public class CountPairs {
	Scanner keyboard = new Scanner(System.in);
	String inputString;
	int numPairs;
	
	 public int pairCount() {
		 numPairs=0;
		 System.out.println("Input a string to find its pairs:");
		 inputString=keyboard.nextLine();
		 for(int i=1;i<inputString.length();i++) {
			 if(inputString.charAt(i) == inputString.charAt(i-1)) {
				 numPairs++;
			 }
		 }
		 return numPairs;
	 }
	
}
