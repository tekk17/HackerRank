package algorithms;

import java.util.Scanner;

public class BetweenTwoSets {

	static int getTotalX(int[] a, int[] b, int na, int mb) {
		int maxA = 0;
		int count = 0;
		maxA = a[na-1];
		int k = 1;
		while(maxA <= b[0]) {
			boolean elementFound = true;
			for(int j=0;j<na;j++) {
				int remainder = 0;
				remainder = maxA % a[j];
				if(remainder != 0) {
					elementFound = false;
					maxA = a[na-1] * (++k);
					break;
				}
			}
			if(elementFound) {
				break;
			}
		}
		
		int newVal = maxA;
		int i=1;
		while(newVal <= b[0]) {
			boolean increaseCount = true;
			for(int j=0;j<mb;j++) {
				int remainder = 0;
				remainder = b[j] % newVal;
				if (remainder != 0) {
					increaseCount = false;
					break;
				}
			}
			if(increaseCount) {
				count += 1;
				newVal = maxA * (++i);
			} else {
				newVal = maxA * (++i);
			}
		}
		
		
		return count;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        
        for(int i=0;i<n;i++) {
            for(int j=1;j<n;j++) {
                if(a[j-1] > a[j]) {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
        for(int i=0;i<m;i++) {
            for(int j=1;j<m;j++) {
                if(b[j-1] > b[j]) {
                    int temp = b[j];
                    b[j] = b[j-1];
                    b[j-1] = temp;
                }
            }
        }
        int total = getTotalX(a, b, n, m);
        System.out.println(total);
        in.close();
	}

}
