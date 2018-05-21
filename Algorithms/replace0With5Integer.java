package easy;

import java.util.Scanner;

public class replace0With5Integer {

	public static int performBase10Division(int integer) {
		int replacedInt = 0;
		int i=0;
		int quotient = 0;
		int remainder = 0;

		while(integer >= 10) {
			quotient = integer/10;
			remainder = integer%10;
			if(remainder == 0) {
				int value = (int) Math.pow(10,i);
				replacedInt += (5*(value));
			} else {
				int value = (int) Math.pow(10,i);
				//System.out.print(value);
				replacedInt += (remainder * value);
			}
			i += 1;
			integer = quotient;
		}

		int value = (int) Math.pow(10,i);
		replacedInt += (integer*(value));
		return replacedInt;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int noOfTests = in.nextInt();
		for(int i=0;i<noOfTests;i++) {
			int integer = in.nextInt();
			int replacedInteger = performBase10Division(integer);
			System.out.println(replacedInteger);
		}
		in.close();
	}
}
