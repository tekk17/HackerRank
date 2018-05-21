package dataStructures;

import java.util.Scanner;

public class ArrayElementsWithinDistanceK {
	int[] hashTableElements;

	ArrayElementsWithinDistanceK(int size) {
		hashTableElements = new int[size];
	}

	public boolean findArrayElementsWithinK(int[] elements, int distance) {
		for(int i=0;i<elements.length;i++) {
			if(hashTableElements[elements[i]] == 0) {
				hashTableElements[elements[i]] = i;
			} else {
				int lastPosition = hashTableElements[elements[i]];
				if((i-lastPosition)<= distance) {
					hashTableElements[elements[i]] = i;
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rangeOfElements = in.nextInt();
		int distance = in.nextInt();
		int noOfElements = in.nextInt();
		ArrayElementsWithinDistanceK arrayElementsWithinDistanceK = new ArrayElementsWithinDistanceK(rangeOfElements);
		int[] elements = new int[noOfElements];
		for(int i=0;i<noOfElements;i++) {
			elements[i] = in.nextInt();
		}

		boolean result = arrayElementsWithinDistanceK.findArrayElementsWithinK(elements,distance);
		System.out.println(result);
	}
}
