package algorithms;

import java.util.Scanner;

public class QuickSort {

	public int performPartition(int[] elements, int low, int high) {
		int pivot = elements[high];
		int i = low - 1;

		for(int j=low;j<high;j++) {
			if(elements[j] < pivot) {
				i++;
				int temp = elements[i];
				elements[i] = elements[j];
				elements[j] = temp;
			}
		}

		int temp = elements[i+1];
		elements[i+1] = elements[high];
		elements[high] = temp;

		return i+1;
	}

	public void performQuickSort(int[] elements, int low, int high) {
		if(low < high) {
			int partitionIndex = performPartition(elements,low,high);

			performQuickSort(elements,low,partitionIndex-1);
			performQuickSort(elements,partitionIndex+1,high);
		}
	}

	public void printQuickSort(int[] elements) {
		for(int i=0;i<elements.length;i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int size = in.nextInt();
		int[] elements = new int[size];

		for(int i=0;i<size;i++) {
			elements[i] = in.nextInt();
		}

		QuickSort quickSort = new QuickSort();
		quickSort.performQuickSort(elements,0,size-1);
		quickSort.printQuickSort(elements);
	}
}
