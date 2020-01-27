package acronyms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Acronyms {
	public static void main(String[] args) {
		String filePath = new File("").getAbsolutePath().concat("/src/acronyms/acronyms.txt");
		File acronyms = new File(filePath);
		Map<String,String> pairs = new TreeMap<>();
		try {
			Scanner readTxt = new Scanner(acronyms);
			while(readTxt.hasNextLine()) {
				String[] input = readTxt.nextLine().split(" - ");
				pairs.put(input[0], input[1]);
			}
			readTxt.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner key = new Scanner(System.in);
		System.out.println("Input: ");
		String sentence = key.nextLine();
		key.close();
		String[] words = sentence.split(" ");
		sentence = "";
		for(int i = 0;i<words.length;i++) {
			if(words[i].contains(".")) {
				words[i] = words[i].replace('.',' ').split(" ")[0];
			}
			if(pairs.get(words[i])!=null) {
				words[i] = pairs.get(words[i]);
			}
			sentence += " "+ words[i];
		}
		System.out.println(sentence);
		
	}
}
