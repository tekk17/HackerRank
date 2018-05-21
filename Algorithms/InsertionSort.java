package algorithms;

import java.util.Scanner;

public class InsertionSort {
	int[] elements;

	InsertionSort(int size) {
		elements = new int[size];
	}

	public void performInsertionSort() {
		int size = elements.length;

		for(int i=1;i<size;i++) {
			int j=i-1;
			int key = elements[i];
			while(j>=0 && elements[j] > key) {
				elements[j+1] = elements[j];
				j -= 1;
			}
			elements[j+1] = key;
		}
	}

	public void printInsertionSort() {
		for(int i=0;i<elements.length;i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfElements = in.nextInt();
		InsertionSort insertionSort = new InsertionSort(noOfElements);
		for(int j=0;j<noOfElements;j++) {
			insertionSort.elements[j] = in.nextInt();
		}

		insertionSort.performInsertionSort();
		insertionSort.printInsertionSort();

		in.close();
	}
}
