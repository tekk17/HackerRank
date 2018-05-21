package algorithms;

import java.util.Scanner;

public class SubStringsKCharacters {

	public static int findSubStringWithKDistinctChars(String input, int distinct) {
		int result = 0;

		for(int i=0;i<input.length();i++) {
			int distinctCount = 0;
			int[] alphabets = new int[256];

			for(int j=i;j<input.length();j++) {
				if(alphabets[input.charAt(j)] == 0) {
					distinctCount++;
				}

				alphabets[input.charAt(j)]++;

				if(distinctCount == distinct) {
					result++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		int distinct = in.nextInt();
		System.out.println(findSubStringWithKDistinctChars(input,distinct));
	}
}
