package algorithms;

import java.util.Scanner;

public class BearAndSteadyGene {
	public static int count[] = new int[26];
	
	public static int findSubstring(char[] alpha,int length, int sum) {
		boolean first = false;
		int[] countFrequency = new int[26];
		int result = 0;
		for(int i=0;i<length-result;i++) {
			int j=i;
			int traversed = 0;
			int len = sum;
			boolean firstElement = false;
			countFrequency[0] = count[0];
			countFrequency[2] = count[2];
			countFrequency[6] = count[6];
			countFrequency[19] = count[19];
			int[] letterCount = new int[26];
			while(j < length && len > 0) {
				int letter = (int) alpha[j] - 65;
				if(countFrequency[letter] != 0) {
					countFrequency[letter] -= 1;
					traversed += 1;
					letterCount[letter] += 1;
					j++;
					len -= 1;
					if(!firstElement) {
						firstElement=true;
					}
					continue;
				}
				if(firstElement) {
					letterCount[letter] += 1;
					traversed += 1;
				}
				j++;
			}
			if(!first) {
				result = traversed;
				first = true;
				continue;
			}
			if(traversed < result && len == 0) {
				result = traversed;
				continue;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		String s = in.next();
		int frequency = length/4;
		char[] letters = new char[length];
		letters = s.toCharArray();
		int[] alphabets = new int[26];
		
		for(int i=0;i<length;i++) {
			int letter = (int) letters[i] - 65;
			alphabets[letter] += 1;
		}
		
		int sum = 0;
		int result = 0;
		
		for(int i=0;i<26;i++) {
			if(alphabets[i] != 0) {
				if(alphabets[i] == frequency) {
					continue;
				} else {
					int diff = alphabets[i] - frequency;
					if(diff > 0) {
						count[i] = diff;
						sum += diff;
					} 
				}
			}
		}
		
		result = findSubstring(letters, length, sum);
		
		System.out.println(result);
		
		in.close();
	}
}
