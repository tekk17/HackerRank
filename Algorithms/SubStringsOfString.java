package algorithms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SubStringsOfString {

	public static HashSet<Integer> stringSet = new HashSet<>();

	public static void subStringsOfString(String input) {
		int length = input.length();

		for(int i=0;i<length;i++) {
			for(int j=i+1;j<=length;j++) {
				//stringSet.add(Integer.parseInt(input.substring(i,j)));
				System.out.print(input.substring(i,j) + " ");
			}
		}
	}

	public static void main(String[] args) {
		subStringsOfString("aabc");

		/*Iterator<Integer> integerIterator = stringSet.iterator();
		int sum = 0;

		while(integerIterator.hasNext()) {
			int number = integerIterator.next();
			sum = sum + number;
		}

		System.out.println(sum);*/
	}
}
