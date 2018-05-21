package algorithms;

import java.util.Scanner;

public class MaximumSumIncreasingSubArray {

	public int findMaximumSum(int[] elements) {
		int length = elements.length;

		int[] maximumSum = new int[length];

		for(int i=0;i<length;i++) {
			maximumSum[i] = elements[i];
		}

		for(int i=1;i<length;i++) {
			for(int j=0;j<i;j++) {
				if(elements[i] > elements[j] && maximumSum[i] < maximumSum[j] + elements[i]) maximumSum[i] = maximumSum[j] + elements[i];
			}
		}

		int maxSum = 0;

		for(int i=0;i<length;i++) {
			if(maxSum < maximumSum[i]) maxSum = maximumSum[i];
		}

		return maxSum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] elements = new int[size];

		for(int i=0;i<size;i++) {
			elements[i] = in.nextInt();
		}

		MaximumSumIncreasingSubArray maximumSumIncreasingSubArray = new MaximumSumIncreasingSubArray();

		System.out.println(maximumSumIncreasingSubArray.findMaximumSum(elements));

		in.close();
	}
}
