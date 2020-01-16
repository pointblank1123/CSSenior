package letterNumbers;

import java.util.Scanner;

public class LetterNumbers {
	Scanner keyboard= new Scanner(System.in);
	String input;
	String output = "";
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int pos;
	int inputNum;
	public String LetterNums() {
		System.out.println("input a letter and a number: ");
		input = keyboard.nextLine();
		inputNum = Integer.parseInt(input.replaceAll("[\\D]", ""));
		for(int k=inputNum; k>0; k--) {
			pos= alphabet.indexOf(input.substring(0,1).toUpperCase());
			for(int i=inputNum; i>0;i--) {
				for(int j=0; j<inputNum;j++) {
					output += alphabet.charAt(pos);
				}
				output += " ";
				pos++;
			}
			
		}
	return output;
	}
}
