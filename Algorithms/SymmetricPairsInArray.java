package algorithms;

import java.util.Scanner;

public class SymmetricPairsInArray {
	int[][] elements;

	SymmetricPairsInArray(int size) {
		elements = new int[size][2];
	}

	public int performQuickSortPartition(int[][] arrayElements, int low, int high) {
		int pivot = arrayElements[high][0];
		int i = low-1;

		for(int j=low;j<high;j++) {
			if(arrayElements[j][0] <= pivot) {
				i++;
				int[] temp = new int[2];
				temp[0] = arrayElements[j][0];
				temp[1] = arrayElements[j][1];
				arrayElements[j][0] = arrayElements[i][0];
				arrayElements[j][1] = arrayElements[i][1];
				arrayElements[i][0] = temp[0];
				arrayElements[i][1] = temp[1];
			}
		}

		int[] temp = new int[2];
		temp[0] = arrayElements[i+1][0];
		temp[1] = arrayElements[i+1][1];
		arrayElements[i+1][0] = arrayElements[high][0];
		arrayElements[i+1][1] = arrayElements[high][1];
		arrayElements[high][0] = temp[0];
		arrayElements[high][1] = temp[1];

		return i+1;
	}

	public void performQuickSort(int[][] arrayElements, int low, int high) {
		if(low < high) {
			int partitionIndex = performQuickSortPartition(arrayElements,low,high);

			performQuickSort(arrayElements, low, partitionIndex-1);
			performQuickSort(arrayElements,partitionIndex+1, high);
		}
		return;
	}

	public int performBinarySearch(int[][] arrayElements, int low, int high, int key) {
		if(low <= high) {
			int mid = (low+high)/2;

			if(arrayElements[mid][1] == arrayElements[key][0]) {
				if(arrayElements[mid][0] == arrayElements[key][1]) {
					return mid;
				}
			} else if(arrayElements[key][1] <= arrayElements[mid][0]) {
				return performBinarySearch(arrayElements,low,mid-1, key);
			} else {
				return performBinarySearch(arrayElements,mid+1, high, key);
			}
		}
		return -1;
	}

	public void findSymmetricPairs(int[][] arrayElements) {
		int[][] symmetricIndices = new int[(arrayElements.length)][2];
		int top = -1;
		for(int i=0;i<arrayElements.length;i++) {
			int foundIndex = performBinarySearch(arrayElements,i+1, arrayElements.length-1,i);
			if(foundIndex != -1) {
				symmetricIndices[++top][0] = i;
				symmetricIndices[top][1] = foundIndex;
			}
		}

		if(top != -1) {
			for(int i=0;i<=top;i++) {
				System.out.println(arrayElements[symmetricIndices[i][0]][0] + ", " + arrayElements[symmetricIndices[i][0]][1] +" : " + arrayElements[symmetricIndices[i][1]][0] +", " + arrayElements[symmetricIndices[i][1]][1]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfElements = in.nextInt();
		SymmetricPairsInArray symmetricPairsInArray = new SymmetricPairsInArray(noOfElements);
		for(int i=0;i<noOfElements;i++) {
			symmetricPairsInArray.elements[i][0] = in.nextInt();
			symmetricPairsInArray.elements[i][1] = in.nextInt();
		}

		symmetricPairsInArray.performQuickSort(symmetricPairsInArray.elements,0,noOfElements-1);
		symmetricPairsInArray.findSymmetricPairs(symmetricPairsInArray.elements);
	}
}
