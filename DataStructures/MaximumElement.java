package problems;

import java.util.Scanner;

public class MaximumElement {

	public static void main(String[] args) {
		int topOfStack = -1;
		Scanner in = new Scanner(System.in);
		int noOfOperations = in.nextInt();
		long arr[] = new long[noOfOperations];
		long max = 0;
		
		for(int i=1;i<=noOfOperations;i++) {
			int operation = in.nextInt();
			if (operation == 1) {
				//insert item
				long item = in.nextLong();
				arr[++topOfStack] = item;
				if (topOfStack == 0) {
					max = arr[topOfStack];
				}
				if (max < item) {
					max = item;
				}
			} else if (operation == 2) {
				if (max == arr[topOfStack]) {
					max = arr[0];
					for(int j=1;j<=topOfStack-1;j++) {
						if (max < arr[j]) {
							max = arr[j];
						}
					}
				}
				topOfStack -= 1;
				if (topOfStack == -1) {
					max = 0;
				}
			} else if (operation == 3) {
				//print largest element
				/*max = arr[0];
				for(int j=1;j<=topOfStack;j++) {
					if (max < arr[j]) {
						max = arr[j];
					}
				}*/
				System.out.println(max);
			}
		}
		in.close();
	}

}
