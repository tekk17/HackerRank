package dataStructures;

import java.util.Scanner;

public class ReducedFormArray {
	int[][] table;
	int[] elements;

	ReducedFormArray(int size) {
		table = new int[size][2];
		elements = new int[size];
	}

	public void performMerge(int[] numbers,int left, int middle, int right) {
		int size1 = middle-left+1;
		int size2 = right-middle;

		int[] leftArray = new int[size1];
		int[] rightArray = new int[size2];

		for(int i=0;i<size1;i++) {
			leftArray[i] = numbers[left+i];
		}

		for(int j=0;j<size2;j++) {
			rightArray[j] = numbers[middle+1+j];
		}

		int i = 0;
		int j = 0;
		int k = left;

		while(i < size1 && j < size2) {
			if(leftArray[i] < rightArray[j]) {
				numbers[k] = leftArray[i];
				i++;
				k++;
			} else {
				numbers[k] = rightArray[j];
				k++;
				j++;
			}
		}

		while(i<size1) {
			numbers[k] = leftArray[i];
			k++;
			i++;
		}

		while(j<size2) {
			numbers[k] = rightArray[j];
			k++;
			j++;
		}
	}

	public void performMergeSort(int[] numbers, int left, int right) {
		if(left < right) {
			int middle = (left+right)/2;

			performMergeSort(numbers,left,middle);
			performMergeSort(numbers,middle+1,right);

			performMerge(numbers,left,middle,right);
		}
	}

	public void initializeHashTable(int[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			table[i][0] = i;
			table[i][1] = numbers[i];
		}
	}

	public void printReducedFormArray(int[] sortedArray) {
		for(int i=0;i<sortedArray.length;i++) {
			int element = sortedArray[i];
			for(int j=0;j<table.length;j++) {
				if(element == table[j][1]) {
					System.out.print(j + " ");
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int size = in.nextInt();
		ReducedFormArray reducedFormArray = new ReducedFormArray(size);
		int[] originalArray = new int[size];

		for(int i=0;i<size;i++) {
			reducedFormArray.elements[i] = in.nextInt();
			originalArray[i] = reducedFormArray.elements[i];
		}

		reducedFormArray.performMergeSort(reducedFormArray.elements,0,size-1);
		reducedFormArray.initializeHashTable(reducedFormArray.elements);
		reducedFormArray.printReducedFormArray(originalArray);
	}


}
