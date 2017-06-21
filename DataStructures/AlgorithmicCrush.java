package problems;

import java.util.Scanner;

public class AlgorithmicCrush {
	static long arr[];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfElements = in.nextInt();
		int noOfOperation = in.nextInt();
		long x = 0;
		long max = 0;
		//int twoPower = 1;
		
		arr = new long[noOfElements+1];
		
		for (int j=1;j<=noOfOperation;j++) {
			int p = in.nextInt();
			int q = in.nextInt();
			int sum = in.nextInt();
			arr[p] += sum;
			if (q+1 <= noOfElements) arr[q+1] -= sum;
		}
		
		for (int i=1;i<=noOfElements;i++) {
			x = arr[i] + x;
			if (max < x) max = x;
		}
		
		System.out.println(max);
		
		in.close(); 
	}
}
