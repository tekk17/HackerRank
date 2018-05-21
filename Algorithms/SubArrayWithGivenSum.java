package algorithms;

import java.util.HashMap;
import java.util.Scanner;

public class SubArrayWithGivenSum {

	public static void findSubArrayWithGivenSum(int[] elements, int requiredSum) {
		int length = elements.length;
		HashMap<Integer,Integer> sumIndex = new HashMap<>();
		int currentSum = 0;

		for(int i=0;i<length;i++) {
			currentSum += elements[i];

			if(currentSum == requiredSum) {
				System.out.println("Start: 0" + " Last: " + i);
			}

			if(sumIndex.containsKey(currentSum-requiredSum)) {
				int firstIndex = sumIndex.get(currentSum-requiredSum)+1;
				int lastIndex = i;
				System.out.println("Start: " + firstIndex + " Last: " + lastIndex);
			}

			sumIndex.put(currentSum,i);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arraySize = in.nextInt();
		int sum = in.nextInt();
		int[] elements = new int[arraySize];

		for(int i=0;i<arraySize;i++) {
			elements[i] = in.nextInt();
		}

		findSubArrayWithGivenSum(elements,sum);
	}
}
