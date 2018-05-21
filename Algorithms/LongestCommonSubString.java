package algorithms;

import java.util.Scanner;

public class LongestCommonSubString {

	public static int findLongestCommonSubString(String string1, String string2) {
		int length1 = string1.length();
		int length2 = string2.length();

		int[][] subStringLength = new int[length1+1][length2+1];
		int result = 0;

		for(int i=0;i<=length1;i++) {
			for(int j=0;j<=length2;j++) {
				if(i==0 || j==0) {
					subStringLength[i][j] = 0;
				} else if(string1.charAt(i-1) == string2.charAt(j-1)) {
					subStringLength[i][j] = subStringLength[i-1][j-1] + 1;
					if(result < subStringLength[i][j]) {
						result = subStringLength[i][j];
					}
				} else {
					subStringLength[i][j] = 0;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input1 = in.next();
		String input2 = in.next();

		System.out.println(findLongestCommonSubString(input1,input2));
	}
}
