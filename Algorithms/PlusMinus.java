package algorithms;

import java.util.Scanner;

public class PlusMinus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        double positive = 0;
        double negative = 0;
        double zeroes = 0;
        
        for(int i=0;i<n;i++) {
            if(arr[i] > 0) {
                positive +=1;
            } else if (arr[i] == 0) {
                zeroes += 1;
            } else {
                negative += 1;
            }
        }
        
        double positiveFraction = 0;
        double negativeFraction = 0;
        double zeroFraction = 0;
        
        positiveFraction = positive/n;
        negativeFraction = negative/n;
        zeroFraction = zeroes/n;
        
        System.out.println(positiveFraction);
        System.out.println(negativeFraction);
        System.out.println(zeroFraction);
        
        in.close();

	}

}
