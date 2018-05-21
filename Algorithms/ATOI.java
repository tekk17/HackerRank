package algorithms;

import java.util.Scanner;

public class ATOI {
	public int performATOI(String sequence) {
		char[] charSequence = new char[sequence.length()];
		charSequence = sequence.toCharArray();
		int[] integers = new int[sequence.length()];

		for(int i=0;i<charSequence.length;i++) {
			int element = ((int) charSequence[i]) - 48;
			integers[i] = element;
		}

		int power = 0;
		int digits = 0;
		for(int i=integers.length-1;i>=0;i--) {
			int digit = (int)Math.pow(10,power) * integers[i];
			digits = digits + digit;
			power += 1;
		}

		return digits;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		ATOI atoi = new ATOI();
		System.out.println(atoi.performATOI(input));

	}
}
