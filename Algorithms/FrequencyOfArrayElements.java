package algorithms;

import java.util.Scanner;

public class FrequencyOfArrayElements {
	public static int top;

	public int[] calculateFrequency(int[] elements) {
		int length = elements.length;
		int frequencySize = (elements[length-1]) + 1;
		int[] elementFrequency = new int[frequencySize];
		top = -1;

		for(int i=0;i<length-1;) {
			top += 1;
			elementFrequency[elements[i]] += 1;
			int j= i+1;
			if(elements[j] == elements[i]) {
				while(j<length && elements[j] == elements[i]) {
					elementFrequency[elements[i]] += 1;
					j += 1;
				}
			}
			i = j;
		}

		return elementFrequency;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfElements = in.nextInt();
		int[] elements = new int[noOfElements];

		for(int i=0;i<noOfElements;i++) {
			elements[i] = in.nextInt();
		}

		MergeSort mergeSort = new MergeSort();
		mergeSort.performMergeSort(elements,0,noOfElements-1);

		FrequencyOfArrayElements frequencyOfArrayElements = new FrequencyOfArrayElements();

		int[] elementsFrequencies = frequencyOfArrayElements.calculateFrequency(elements);

		for(int i=0;i<elementsFrequencies.length;i++) {
			if(elementsFrequencies[i] != 0) {
				System.out.println(i + " : " + elementsFrequencies[i]);
			}
		}
	}
}
