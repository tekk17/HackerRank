package easy;

import java.util.Scanner;

public class isStringRotatedByTwoPlaces {

	public static int areStringSame(String s1, String s2) {
		char[] s1Chars = s1.toCharArray();
		char[] s2Chars = s2.toCharArray();
		int s1Length = s1Chars.length;
		int s2Length = s2Chars.length;

		int value = 0;
		char temp1 = s2Chars[s2Length - 1];
		char temp2 = s2Chars[s2Length - 2];
		for (int j = s2Length - 3; j >= 0; j--) {
			s2Chars[j + 2] = s2Chars[j];
		}
		s2Chars[0] = temp2;
		s2Chars[1] = temp1;
		String s2Rotated = new String(s2Chars);
		if (s2Rotated.equals(s1)) {
			value = 1;
		}

		if (value == 0) {
			s2Chars = s2.toCharArray();
			char tempClock1 = s2Chars[0];
			char tempClock2 = s2Chars[1];
			for (int j = 2; j < s2Length; j++) {
				s2Chars[j - 2] = s2Chars[j];
			}
			s2Chars[s2Length - 2] = tempClock1;
			s2Chars[s2Length - 1] = tempClock2;
			String s2RotatedClockWise = new String(s2Chars);
			if (s2RotatedClockWise.equals(s1)) {
				value = 1;
			}
		}


		return value;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfCases = in.nextInt();
		for (int i = 0; i < noOfCases; i++) {
			String s1 = in.next();
			String s2 = in.next();
			int result = areStringSame(s1, s2);
			System.out.println(result);
		}
		in.close();
	}
}
