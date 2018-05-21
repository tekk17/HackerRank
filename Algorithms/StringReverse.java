package algorithms;

import java.util.Scanner;

public class StringReverse {

	public static String performReverse(String current) {
		char[] stringChars = current.toCharArray();
		int length = stringChars.length;
		int[][] spacePositions = new int[length][1];
		int count = -1;
		for(int i=0;i<length;) {
			if(stringChars[i] == 32) {
				spacePositions[++count][0] = i;
				i++;
			} else {
				i++;
			}
		}

		if(count == -1) {
			return current;
		}

		char[] resultString = new char[length];

		int i = length-1;
		int j= count;
		int trace = -1;
		while (j != -1) {
			int position = i - spacePositions[j][0];
			for(int k=spacePositions[j][0]+1;k<=i;k++) {
				resultString[++trace] = stringChars[k];
			}
			resultString[++trace] = ' ';
			i = spacePositions[j][0]-1;
			j--;
		}

		for(int last = 0;last<=i;last++) {
			resultString[++trace] = stringChars[last];
		}

		String result = String.valueOf(resultString);

		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String output = performReverse(input);
		System.out.println(output);
		in.close();
	}
}
