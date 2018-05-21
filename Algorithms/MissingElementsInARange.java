package algorithms;

import java.util.Scanner;

public class MissingElementsInARange {

	public int performPartition(int[] elements, int low, int high) {
		int pivot = elements[high];

		int i = low-1;
		for(int j=low;j<high;j++) {
			if(elements[j] < pivot) {
				i+=1;
				int temp = elements[j];
				elements[j] = elements[i];
				elements[i] = temp;
			}
		}

		int temp = elements[i+1];
		elements[i+1] = pivot;
		elements[high] = temp;

		return i+1;
	}

	public void performQuickSort(int[] elements, int low, int high) {
		if(low<high) {
			int middle = performPartition(elements,low,high);

			performQuickSort(elements,low,middle-1);
			performQuickSort(elements,middle+1,high);
		}
	}

	public int performBinarySearch(int[] elements, int low, int high, int key) {
		if(low<=high) {
			int middle = low + (high-low)/2;

			if(elements[middle] == key) {
				return middle;
			} else if(elements[middle] <= key) {
				return performBinarySearch(elements,middle+1,high,key);
			} else {
				return performBinarySearch(elements, low, middle-1,key);
			}
		}
		return -1;
	}

	public void findMissingRange(int[] elements,int left, int right) {
		performQuickSort(elements,0,elements.length-1);

		int leftPosition = performBinarySearch(elements,0,elements.length-1,left);
		int rightPosition = performBinarySearch(elements, leftPosition,elements.length-1,right);

		System.out.print("Missing Elements in Range are: ");
		for(int i=left;i<right;i++) {
			int isFound = performBinarySearch(elements,0,elements.length-1,i);
			if(isFound == -1) {
				System.out.print(i + " ");
			}
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

		int leftRange = in.nextInt();
		int rightRange = in.nextInt();

		MissingElementsInARange missingElementsInARange = new MissingElementsInARange();
		missingElementsInARange.findMissingRange(elements,leftRange,rightRange);
	}
}
