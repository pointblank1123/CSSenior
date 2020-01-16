import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Search {
	Scanner key = new Scanner(System.in);
	File text;
	RandomAccessFile line;
	int iterateNum;
	int year;
	String inputName;
	String output;
	Boolean cont;
	int mid;
	int max;
	int min;
	String alpha = "abcdefghijklmnopqrstuvwxyz";
	
	public Search() throws IOException {
		System.out.println("input a year between 1880 and 2019 (inclusive): ");
		year = key.nextInt();
		System.out.println("Input a name to search for: ");
		inputName = key.next().toLowerCase();
		iterateNum =0;
		text= new File(Search.class.getResource("/names/yob"+year+"sorted.txt").getPath());
		try {
			line = new RandomAccessFile(text,"r");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		output="";
		cont = true;
		min = 0;
		max = findMax();
		mid = max/2;
	}
	
	public String searchLinear() throws IOException {
		line.seek(0);
		while(cont) {
			String temp = line.readLine();
			System.out.println(temp.split(",")[0].toLowerCase());
			if(temp.split(",")[0].toLowerCase()==inputName) {
				output+= temp + " ";
				if(output.split(" ").length == 2) {
					cont=false;
				}
			}
			iterateNum ++;
		}
		return output + iterateNum + " Iterations";
	}
	
	public String searchBinary() throws IOException {
		line.seek(0);
		iterateNum = 0;
		while(cont) {
			line.seek(mid);
			String temp = line.readLine();
			if(alpha.indexOf(line.readChar()) > alpha.indexOf(inputName.charAt(1))) {
				max = mid;
			}
			else if(alpha.indexOf(line.readChar()) < alpha.indexOf(inputName.charAt(1))){
				min = mid;
			}
			else if(alpha.indexOf(line.readChar()) == alpha.indexOf(inputName.charAt(1))) {
				
				if(alpha.indexOf(line.readChar()) > alpha.indexOf(inputName.charAt(2))) {
					max = mid;
				}
				else if(alpha.indexOf(line.readChar()) < alpha.indexOf(inputName.charAt(2))){
					min = mid;
				}
				else if(alpha.indexOf(line.readChar()) == alpha.indexOf(inputName.charAt(2))) {
					if(alpha.indexOf(line.readChar()) > alpha.indexOf(inputName.charAt(3))) {
						max = mid;
					}
					else if(alpha.indexOf(line.readChar()) < alpha.indexOf(inputName.charAt(3))){
						min = mid;
					}
					else if(alpha.indexOf(line.readChar()) == alpha.indexOf(inputName.charAt(3))) {
						temp = line.readLine();
						if(temp.split(",")[0].toLowerCase() == inputName) {
							output+=temp + " ";
							if(output.split(" ").length==2) {
								cont=false;
							}
						}
					}
				}
			}
			iterateNum++;
		}
		return output + iterateNum + " Iterations";
	}

	public int findMax() throws IOException {
		
		while(line.getFilePointer() < line.length()) {
			line.readLine();
			max++;
		}
		return max;
	}
}
