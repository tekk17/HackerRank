package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class NonDivisibleSubset {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] remainders = new int[k];
		for(int i=0;i<n;i++) {
		    int num = in.nextInt();
			remainders[num%k]++;
		}
		int result = 0;
		if(k%2 == 0) {
		    result += 1;
        }
        result += Math.min(remainders[0],1);
        for(int i=1;i<=k/2;i++) {
            if(i != k-i) result += Math.max(remainders[i], remainders[k - i]);
        }
		
		System.out.println(result);
		in.close();

	}

}
