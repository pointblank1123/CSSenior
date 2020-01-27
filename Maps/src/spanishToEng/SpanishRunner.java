package spanishToEng;

import java.io.*;
import java.util.Scanner;

public class SpanishRunner {
	public static void main(String[] args) {
		SpanishToEng stoe = new SpanishToEng();
		Scanner key = new Scanner(System.in);
		System.out.println("Input a line to translate: ");
		String output = stoe.putEntry(key.nextLine());
		System.out.println(output);
	}
}
