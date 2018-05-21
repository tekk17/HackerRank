package dataStructures;

import java.util.Scanner;

public class MaximumSubArray0 {
	int[] hashTable;
	MaximumSubArray0(int sizeOfTable) {
		hashTable = new int[sizeOfTable];
	}

	public int calculateLargestSubArray(int[] arrayElements) {
		int sizeOfArray = arrayElements.length;
		int max = -1;
		int firstIndex = -1;
		int lastIndex = -1;

		for(int i=0;i<sizeOfArray;i++) {
			int sum = arrayElements[i];

			for(int j=i+1;j<sizeOfArray;j++) {
				sum = sum + arrayElements[j];
				if(sum == 0) {
					int size = j-i+1;
					if(max < size) {
						max = size;
						firstIndex = i;
						lastIndex = j;
					}
				}
			}
		}
		//System.out.println("Largest SubArray: " + max + "First Index: " + firstIndex + "Last Index: " + lastIndex);
		return max;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int noOfElements = in.nextInt();


		int[] arrayElements = new int[noOfElements];
		for(int i=0;i<noOfElements;i++) {
			arrayElements[i] = in.nextInt();
		}

		MaximumSubArray0 maximumSubArray0 = new MaximumSubArray0(noOfElements);
		int result = maximumSubArray0.calculateLargestSubArray(arrayElements);
		System.out.println(result);
		in.close();
	}
}
