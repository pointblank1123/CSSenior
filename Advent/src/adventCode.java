import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class adventCode {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File input = new File(adventCode.class.getResource("input").getPath());
		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<Integer> inputArr = new ArrayList<>();
		ArrayList<Integer> outputArr = new ArrayList<>();
		String line = br.readLine();
		for(int i=0;i<line.split(",").length;i++) {
			inputArr.add(Integer.parseInt(line.split(",")[i]));
		}
		inputArr.set(1, 12);
		inputArr.set(2,2);
		for(int pos=0;pos<inputArr.size();pos+=4) {
			inputArr.set(inputArr.get(pos+3),inputArr.get(inputArr.get(pos+1))+inputArr.get(inputArr.get(pos+2)));
		}
		System.out.println(inputArr.get(0));
	}

}
