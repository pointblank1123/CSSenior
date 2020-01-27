package spanishToEng;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SpanishToEng {
	private Map<String,String> pairs = new TreeMap<>();
	private String[] input;
	private String filePath = new File("").getAbsolutePath().concat("/src/spanishToEng/spanToEng.txt");
	private File translations = new File(filePath);
	private String output = "";
	public SpanishToEng()
	{
		try {
			Scanner scnr = new Scanner(translations);
			while(scnr.hasNextLine()) {
				input = scnr.nextLine().split("=");
				pairs.put(input[1],input[0]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pairs);
	}

	public String putEntry(String entry)
	{
		String[] list = entry.split(" ");
		for(int i =0;i<list.length;i++) {
			output += " "+translate(list[i]);
		}
		return output;
	}

	public String translate(String sent)
	{
		String translated = pairs.get(sent);
		return translated;
	}
}
