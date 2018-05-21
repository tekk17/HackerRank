package algorithms;

import java.util.Scanner;

public class MaximumSumSubArray {

	public int findMaximumSum(int[] elements, int left, int middle, int right) {
		int minLeft = Integer.MIN_VALUE;
		int sum = 0;

		for(int i=middle;i>=left;i--) {
			sum = sum + elements[i];
			if(sum > minLeft) {
				minLeft = sum;
			}
		}

		sum = 0;
		int minRight = Integer.MIN_VALUE;
		for(int j=middle+1;j<=right;j++) {
			sum = sum + elements[j];
			if(sum > minRight) {
				minRight = sum;
			}
		}

		return minLeft+minRight;
	}

	public int partitionSubArray(int[] elements, int left, int right) {
		if(left == right) {
			return elements[left];
		}

		int middle = (left+right)/2;

		return Math.max(Math.max(partitionSubArray(elements,left,middle),partitionSubArray(elements,middle+1,right)),findMaximumSum(elements,left,middle,right));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] elements = new int[size];

		for(int i=0;i<size;i++) {
			elements[i] = in.nextInt();
		}

		MaximumSumSubArray maximumSumSubArray = new MaximumSumSubArray();
		int middle = size/2;
		int returnedSum = maximumSumSubArray.findMaximumSum(elements,0,middle,size-1);
		int maxSum = maximumSumSubArray.partitionSubArray(elements,0,size-1);
		System.out.println(maxSum);
	}
}
