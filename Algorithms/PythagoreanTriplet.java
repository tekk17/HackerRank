package algorithms;

import java.util.Arrays;

public class PythagoreanTriplet {

	public static void findPythagoreanTriplet(int[] elements) {
		Arrays.sort(elements);

		int[] elementsSquares = new int[elements.length];

		for(int i=0;i<elements.length;i++) {
			elementsSquares[i] = elements[i] * elements[i];
		}

		for(int i= elementsSquares.length-1;i>=2;i--) {
			int left = 0;
			int right = i-1;

			while(left < right) {
				int sum = elementsSquares[left] + elementsSquares[right];

				if(sum == elementsSquares[i]) {
					System.out.println("Triplets: " + elements[left] + " " + elements[right] + " " + elements[i]);
					break;
				} else if(sum > elementsSquares[i]) {
					right--;
				} else {
					left++;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] elements = {15, 8, 17, 3, 4, 5, 8, 6, 10};
		findPythagoreanTriplet(elements);
	}

}
