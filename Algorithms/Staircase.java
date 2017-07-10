package algorithms;

import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int k = n-1;
        for (int i=1;i<=n;i++) {
            int j=1;
            while(j<=k) {
                System.out.print(" ");
                j++;
            }
            for(int l=k+1;l<=n;l++) {
                System.out.print("#");
            }
            k = k-1;
            System.out.println();
        }
        in.close();

	}

}
