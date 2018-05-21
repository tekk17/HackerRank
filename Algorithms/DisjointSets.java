package algorithms;

import java.util.Scanner;

public class DisjointSets {
	int[] set1;
	int[] set2;

	DisjointSets(int size1, int size2) {
		set1 = new int[size1];
		set2 = new int[size2];
	}

	public void performMerge(int[] elements, int low, int middle, int high) {
		int size1 = middle-low+1;
		int size2 = high-middle;

		int[] firstArray = new int[size1];
		int[] secondArray = new int[size2];

		for(int i=0;i<size1;i++) {
			firstArray[i] = elements[low+1];
		}

		for(int j=0;j<size2;j++) {
			secondArray[j] = elements[middle+j+1];
		}

		int i=0;
		int j=0;
		int k=0;

		while(i<size1 && j<size2) {
			if(firstArray[i] < secondArray[j]) {
				elements[k] = firstArray[i];
				k++;
				i++;
			} else {
				elements[k] = secondArray[j];
				k++;
				j++;
			}
		}

		while(i<size1) {
			elements[k] = firstArray[i];
			k++;
			i++;
		}

		while(j<size2) {
			elements[k] = secondArray[j];
			k++;
			j++;
		}
	}

	public void performMergeSort(int[] elements, int low, int high) {
		if(low<high) {
			int middle = (low+high)/2;
			performMergeSort(elements,low,middle);
			performMergeSort(elements,middle+1,high);

			performMerge(elements,low,middle,high);
		}
	}

	public void findDisjointSet(int[] array1, int[] array2) {
		int size1 = array1.length;
		int size2 = array2.length;

		int[] disjointSet = new int[size1+size2];
		int top = -1;

		int i=0;
		int j=0;

		while(i<size1 && j<size2) {
			if(array1[i] == array2[j]) {
				disjointSet[++top] = array1[i];
				i++;
				j++;
			} else if(array1[i] < array2[j]) {
				i++;
			} else {
				j++;
			}
		}

		if(top != -1) {
			System.out.print("Not a disjoint set : ");
			for(int t=0;t<=top;t++) {
				System.out.print(disjointSet[t] + " ");
			}
			System.out.println();
		} else {
			System.out.println("Disjoint Sets");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int elementsInSet1 = in.nextInt();
		int elementsInSet2 = in.nextInt();

		DisjointSets disjointSets = new DisjointSets(elementsInSet1,elementsInSet2);

		for(int i=0;i<elementsInSet1;i++) {
			disjointSets.set1[i] = in.nextInt();
		}

		for(int i=0;i<elementsInSet2;i++) {
			disjointSets.set2[i] = in.nextInt();
		}

		disjointSets.performMergeSort(disjointSets.set1,0,elementsInSet1-1);
		disjointSets.performMergeSort(disjointSets.set2,0,elementsInSet2-1);



		disjointSets.findDisjointSet(disjointSets.set1,disjointSets.set2);
	}
}
