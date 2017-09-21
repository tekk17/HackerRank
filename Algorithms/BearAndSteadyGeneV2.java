package algorithms;

import java.util.Scanner;

public class BearAndSteadyGeneV2 {
	public static boolean isStringSteady(int[] alphaFrequencies, int frequency) {
		boolean isSteady = true;
		for(int i=0;i<26;i++) {
			if(alphaFrequencies[i] != 0) {
				if(alphaFrequencies[i] <= frequency) {
					continue;
				} else {
					isSteady = false;
					break;
				}
			}
		}
		return isSteady;
	}
	
	public static int isMinimum(int left, int right) {
		int value = left<right?left:right;
		return value;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		String s = in.next();
		char[] alphabets = new char[length];
		alphabets = s.toCharArray();
		int[] letterFrequency = new int[26];
		int frequency = length/4;
		
		for(int i=0;i<length;i++) {
			int letter = (int) alphabets[i] - 65;
			letterFrequency[letter] += 1;
		}
		
		int left = 0;
		int right = 0;
		int result = Integer.MAX_VALUE;
		
		while(right < length-1) {
			int alphabet = (int) alphabets[right++] - 65;
			letterFrequency[alphabet] -= 1;
			while(isStringSteady(letterFrequency, frequency)) {
				result = isMinimum(result,right-left);
				int alpha = (int) alphabets[left++] - 65;
				letterFrequency[alpha] += 1;
			}
		}
		
		System.out.println(result);
		in.close();
	}
}
