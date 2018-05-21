package algorithms;

import java.util.Scanner;

public class LongestIncreasingSubSequence {
	public int findLongestSequence(int[] elements) {
		int length = elements.length;
		int[] longestSequence = new int[length];

		for(int i=0;i<length;i++) {
			longestSequence[i] = 1;
		}

		for(int i=1;i<length;i++) {
			for(int j=0;j<i;j++) {
				if(elements[i] > elements[j] && longestSequence[i] < (longestSequence[j]+1)) {
					longestSequence[i] = longestSequence[j] + 1;
				}
			}
		}

		int maxLength = 0;

		for(int i=0;i<length;i++) {
			if(maxLength < longestSequence[i]) maxLength = longestSequence[i];
		}

		return maxLength;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfElements = in.nextInt();

		int[] input = new int[noOfElements];

		for(int i=0;i<noOfElements;i++) {
			input[i] = in.nextInt();
		}

		LongestIncreasingSubSequence longestIncreasingSubSequence = new LongestIncreasingSubSequence();

		System.out.println(longestIncreasingSubSequence.findLongestSequence(input));

		in.close();
	}
}
