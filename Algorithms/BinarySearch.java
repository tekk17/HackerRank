package algorithms;

import java.util.Scanner;

public class BinarySearch {

	public int performBinarySearch(int[] elements, int low, int high, int key) {
		if(low <= high) {
			int mid = low + (high-low)/2;

			if(elements[mid] == key)
				return mid;

			else if(elements[mid] < key) {
				return performBinarySearch(elements,mid+1,high,key);
			}

			else {
				return performBinarySearch(elements,low,mid-1,key);
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();

		int[] elements = new int[size];
		for(int i=0;i<size;i++) {
			elements[i] = in.nextInt();
		}

		BinarySearch binarySearch = new BinarySearch();
		int key = in.nextInt();
		System.out.println("Element " + key + " present at the position: " + binarySearch.performBinarySearch(elements,0,size-1,key));
	}
}
