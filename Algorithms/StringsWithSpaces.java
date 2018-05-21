package easy;

import java.util.Scanner;

public class StringsWithSpaces {
	public static void printAllStrings(String str, char[] buf, int i , int j, int n) {
		if(i == n) {
			buf[j] = '\0';
			System.out.println(buf);
			return;
		}

		buf[j] = str.charAt(i);
		printAllStrings(str,buf,i+1,j+1,n);

		buf[j] = ' ';
		buf[j+1] = str.charAt(i);
		printAllStrings(str, buf,i+1, j+2,n);
	}

	public static void findBufSpace(String str) {
		int strLen = str.length();

		char[] buffer = new char[2*strLen];
		buffer[0] = str.charAt(0);

		printAllStrings(str,buffer,1,1,strLen);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();

		for(int i=0;i<noOfTestCases;i++) {
			String str = in.next();
			findBufSpace(str);
		}
	}
}
