package uniInterDiff;

import java.util.*;

public class UniInterDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a;
		String[] b;
		Set<Integer> aSet = new TreeSet<>();
		Set<Integer> bSet = new TreeSet<>();
		ArrayList<Integer> aList = new ArrayList<>();
		ArrayList<Integer> bList = new ArrayList<>();
		Scanner key = new Scanner(System.in);
		Set<Integer> union = new TreeSet<>();
		Set<Integer> inter = new TreeSet<>();
		Set<Integer> diffAB = new TreeSet<>();
		Set<Integer> diffBA = new TreeSet<>();
		Set<Integer> symDiff = new TreeSet<>();
		System.out.println("Input Set 1: ");
		a = key.nextLine().split(" ");
		System.out.println("Input Set 2: ");
		b = key.nextLine().split(" ");
		key.close();
		for(int i = 0; i<a.length;i++) {
			aSet.add(Integer.parseInt(a[i]));
		}
		for(int j = 0; j<b.length;j++) {
			bSet.add(Integer.parseInt(b[j]));
		}
		aList.addAll(aSet);
		bList.addAll(bSet);
		for(int i = 0; i<aList.size();i++) {
			union.add(aList.get(i));
			diffAB.add(aList.get(i));
		}
		for(int j = 0; j<bList.size();j++) {
			
			if(union.add(bList.get(j))==false) {
				inter.add(bList.get(j));
			}
			diffBA.add(bList.get(j));
		}
		diffAB.removeAll(inter);
		diffBA.removeAll(inter);
		symDiff.addAll(union);
		symDiff.removeAll(inter);
		System.out.println("Union: " + union);
		System.out.println("Intersection: " + inter);
		System.out.println("Difference A-B: " + diffAB);
		System.out.println("Difference B-A: " + diffBA);
		System.out.println("Symmetric Difference: " + symDiff);
	}

}
