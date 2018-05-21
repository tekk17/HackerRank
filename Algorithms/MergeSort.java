package algorithms;

import java.util.Scanner;

public class MergeSort {

	public void performMerge(int[] arrayElements, int left, int middle, int right) {
		int size1 = middle - left + 1;
		int size2 = right - middle;

		int[] arrayElements1 = new int[size1];
		int[] arrayElements2 = new int[size2];

		for(int i=0;i<size1;i++) {
			arrayElements1[i] = arrayElements[left+i];
		}

		for(int j=0;j<size2;j++) {
			arrayElements2[j] = arrayElements[middle+1+j];
		}

		int i=0;
		int j=0;
		int k=left;

		while (i<size1 && j<size2) {
			if(arrayElements1[i] < arrayElements2[j]) {
				arrayElements[k] = arrayElements1[i];
				i++;
			} else {
				arrayElements[k] = arrayElements2[j];
				j++;
			}
			k++;
		}

		while(i<size1) {
			arrayElements[k] = arrayElements1[i];
			i++;
			k++;
		}

		while(j<size2) {
			arrayElements[k] = arrayElements2[j];
			j++;
			k++;
		}
	}

	public void performMergeSort(int[] arrayElements, int left, int right) {
		if(left < right) {
			int middle = (left+right)/2;
			performMergeSort(arrayElements,left,middle);
			performMergeSort(arrayElements,middle+1,right);

			performMerge(arrayElements,left,middle,right);
		}
	}

	public void printMergeSort(int[] arrayElements) {
		for(int i=0;i<arrayElements.length;i++) {
			System.out.print(arrayElements[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] arrayElements = new int[size];
		for(int i=0;i<size;i++) {
			arrayElements[i] = in.nextInt();
		}

		MergeSort mergeSort = new MergeSort();
		mergeSort.performMergeSort(arrayElements,0,size-1);
		mergeSort.printMergeSort(arrayElements);

	}

}
