import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
	int max;
	int min;
	int year;
	ArrayList <String> names = new ArrayList<>();
	String alpha = "abcdefghijklmnopqrstuvwxyz";
	String partition;
	Boolean cont;
	int i;
	int randPartition;
	Scanner key= new Scanner(System.in);
	File text;
	FileReader fr;
	BufferedReader reader;
	Random rand = new Random();
	
	
	public QuickSort() throws IOException{
		System.out.println("input a year to sort between 1880 and 2018 (inclusive): ");
		year = key.nextInt();
		text = new File(QuickSort.class.getResource("/names/yob"+year+".txt").getPath());
		fr = new FileReader(text);
		reader = new BufferedReader(fr);
		fileToArray();
		cont = true;
		max = names.size();
	}
	
	public void SortUpper(int min, int i) {
		randPartition = rand.nextInt(max);
		partition = names.get(randPartition);
		names.set(min, partition);
		names.remove(randPartition);
		for(;i<max;i++) {
			if(alpha.indexOf(partition.charAt(0))<alpha.indexOf(names.get(i).charAt(0))) {
				names.set(max+1,names.get(i));
				names.remove(i);
			}
			else if(alpha.indexOf(partition.charAt(0))==alpha.indexOf(names.get(i).charAt(0))) {
				if(alpha.indexOf(partition.charAt(1))<alpha.indexOf(names.get(i).charAt(1))) {
					names.set(max+1,names.get(i));
					names.remove(i);
				}
				else if(alpha.indexOf(partition.charAt(2))==alpha.indexOf(names.get(i).charAt(1))) {
					if(alpha.indexOf(partition.charAt(2))<alpha.indexOf(names.get(i).charAt(2))) {
						names.set(max+1,names.get(i));
						names.remove(i);
					}
					else if(alpha.indexOf(partition.charAt(2))==alpha.indexOf(names.get(i).charAt(2))) {
						if(alpha.indexOf(partition.charAt(2))<alpha.indexOf(names.get(i).charAt(2))) {
							names.set(max+1,names.get(i));
							names.remove(i);
						}
					}
				}
			}
		}
		min = names.indexOf(partition) ;
		SortUpper(min, min+1);
		SortLower(min, min-1);
	}
	public void SortLower(int max, int i) {
		randPartition = rand.nextInt(max);
		partition = names.get(randPartition);
		names.set(min, partition);
		names.remove(randPartition);
		for(;i<max;i++) {
			if(alpha.indexOf(partition.charAt(0))>alpha.indexOf(names.get(i).charAt(0))) {
				names.set(max-1,names.get(i));
				names.remove(i);
			}
			else if(alpha.indexOf(partition.charAt(0))==alpha.indexOf(names.get(i).charAt(0))) {
				if(alpha.indexOf(partition.charAt(1))<alpha.indexOf(names.get(i).charAt(1))) {
					names.set(max-1,names.get(i));
					names.remove(i);
				}
				else if(alpha.indexOf(partition.charAt(2))==alpha.indexOf(names.get(i).charAt(1))) {
					if(alpha.indexOf(partition.charAt(2))<alpha.indexOf(names.get(i).charAt(2))) {
						names.set(max-1,names.get(i));
						names.remove(i);
					}
					else if(alpha.indexOf(partition.charAt(2))==alpha.indexOf(names.get(i).charAt(2))) {
						if(alpha.indexOf(partition.charAt(2))<alpha.indexOf(names.get(i).charAt(2))) {
							names.set(max-1,names.get(i));
							names.remove(i);
						}
					}
				}
			}
		}
		SortUpper(min, min+1);
		SortLower(min, min-1);
	}
	
	public void fileToArray() throws IOException {
		String line = reader.readLine();
		while(line != null) {
			names.add(line);
			line = reader.readLine();
		}
	}
}
