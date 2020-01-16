package test;
import java.util.*;
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Double> set = new HashSet<Double>();
		//set.add("23.22");
		
		Set<Integer> s = new TreeSet<Integer>();
		Set<Integer> s2 = new HashSet<Integer>();
		s.add(1);
		s.add(2);
		s.add(3);
		s2.add(3);
		s2.add(2);
		s2.add(1);
		System.out.println(s.equals(s2));
	}

}
