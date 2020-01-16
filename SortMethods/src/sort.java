import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class sort{
	Scanner key = new Scanner(System.in);
	File text;
	RandomAccessFile line;
	int year;
	boolean cont;
	String alpha = "abcdefghijklmnopqrstuvwxyz";
	ArrayList<String> textArr = new ArrayList<>();
	boolean swap;
	File output;
	FileWriter fw;
	BufferedWriter writer;
	//SelectionSort Group
	File output2;
	FileWriter fw2;
	BufferedWriter writer2;
	ArrayList<String> textArr2 = new ArrayList<>();
	RandomAccessFile line2;
	
	public sort() throws IOException {
		System.out.println("Input a year between 1880 and 2018 to sort: ");
		year = key.nextInt();
		text= new File(sort.class.getResource("/names/yob"+year+".txt").getPath());
		line = new RandomAccessFile(text,"r");
		line2 = new RandomAccessFile(text,"r");
		fileToArray();
		fileToArray2();
		output = new File((sort.class.getResource("/names").getPath()+"/"+year+"sorted.txt"));
		output.createNewFile();
		fw = new FileWriter(output);
		writer = new BufferedWriter(fw,(int) line.length());
		output2 = new File((sort.class.getResource("/names").getPath()+"/"+year+"selSorted.txt"));
		output2.createNewFile();
		fw2 = new FileWriter(output2);
		writer2 = new BufferedWriter(fw2,(int) line.length());
	}
	public void bubbleSort() throws IOException {
		swap=true;
		while(swap) {
			swap = false;
			for(int i = 0; i<textArr.size()-1;i++) {
				String temp = textArr.get(i).toLowerCase();
				String temp1 = textArr.get(i+1).toLowerCase();
				if(alpha.indexOf(temp.charAt(0)) > alpha.indexOf(temp1.charAt(0))) {
					textArr.set(i+1,temp);
					textArr.set(i,temp1);
					swap = true;
				}
				else if(alpha.indexOf(temp.charAt(0)) == alpha.indexOf(temp1.charAt(0))) {
					if(alpha.indexOf(temp.charAt(1)) > alpha.indexOf(temp1.charAt(1))) {
						textArr.set(i+1,temp);
						textArr.set(i,temp1);
						swap = true;
					}
					else if(alpha.indexOf(temp.charAt(1)) == alpha.indexOf(temp1.charAt(1))) {
						if(alpha.indexOf(temp.charAt(2)) > alpha.indexOf(temp1.charAt(2))) {
							textArr.set(i+1,temp);
							textArr.set(i,temp1);
							swap = true;
						}
					}
				}
			}
		}
		arrayToFile();
	}
	public void selectionSort() throws IOException {
		String name = textArr2.get(0);
		int maxNum = Integer.parseInt(name.split(",")[2]);
		for(int i = 1; i<textArr2.size();i++) {
			String tempName = textArr2.get(i);
			int tempNum = Integer.parseInt(name.split(",")[2]);
			if(tempNum > maxNum) {
				maxNum = tempNum;
				name = tempName;
			}
			else if(tempNum == maxNum) {
				if(alpha.indexOf(tempName.charAt(0))>alpha.indexOf(name.charAt(0))) {
					name = tempName;
				}
				else if(alpha.indexOf(tempName.charAt(0))==alpha.indexOf(name.charAt(0))) {
					if(alpha.indexOf(tempName.charAt(1))>alpha.indexOf(name.charAt(1))) {
						name = tempName;
					}
					else if(alpha.indexOf(tempName.charAt(1))==alpha.indexOf(name.charAt(1))) {
						if(alpha.indexOf(tempName.charAt(2))>alpha.indexOf(name.charAt(2))) {
							name = tempName;
						}
					}
				}
			}
			textArr2.set(0, name);
		}
		try {
			arrayToFileSel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fileToArray() throws IOException {
		while(line.getFilePointer() < line.length()) {
			textArr.add(line.readLine());
		}
	}
	public void fileToArray2() throws IOException {
		while(line2.getFilePointer() < line2.length()) {
			textArr2.add(line2.readLine());
		}
	}
	public void arrayToFile() throws IOException {
		for(int i = 0;i<textArr.size();i++) {
			writer.write(textArr.get(i)+"\n");
		}
		writer.flush();
		writer.close();
	}
	public void arrayToFileSel() throws IOException {
		for(int i = 0;i<textArr2.size();i++) {
			writer2.write(textArr2.get(i)+"\n");
		}
		writer2.flush();
		writer2.close();
	}
	
}
