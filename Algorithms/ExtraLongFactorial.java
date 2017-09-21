package algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorial {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		BigInteger N = new BigInteger("1");
		
		for(int i=n;i>0;i--) {
			N = N.multiply(BigInteger.valueOf(i));
		}
		System.out.println(N);
		
		in.close();
	}
}
