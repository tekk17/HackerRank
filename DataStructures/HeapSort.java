package dataStructures;

import java.util.Scanner;

class MaxHeap {
	int capacity;
	int heapSize;
	int[] heapArray;

	MaxHeap(int cap) {
		capacity = cap+1;
		heapSize = 0;
		heapArray = new int[capacity];
	}

	public int getParentPosition(int position) {
		return ((position-1)/2);
	}

	public int getParentLeftChild(int position) {
		return ((position*2)+1);
	}

	public int getParentRightChild(int position) {
		return ((position*2)+2);
	}

	public void swapHeapElements(int position1, int position2) {
		int temp = heapArray[position1];
		heapArray[position1] = heapArray[position2];
		heapArray[position2] = temp;
	}

	public void insertHeapElement(int element) {
		if(heapSize == capacity-1) {
			return;
		}

		int position = heapSize;
		heapArray[heapSize] = element;
		heapSize+= 1;

		while(position != 0 && heapArray[position] > heapArray[getParentPosition(position)]) {
			swapHeapElements(position,getParentPosition(position));
			position = getParentPosition(position);
		}
	}

	public void maxHeapify(int position, int currentHeapSize) {
		int leftChildPosition = getParentLeftChild(position);
		int rightChildPosition = getParentRightChild(position);
		int largest = position;

		if(leftChildPosition < currentHeapSize && heapArray[leftChildPosition] > heapArray[position]) {
			largest = leftChildPosition;
		}
		if(rightChildPosition < currentHeapSize && heapArray[rightChildPosition] > heapArray[largest]) {
			largest = rightChildPosition;
		}
		if(largest != position) {
			swapHeapElements(largest,position);
			position = largest;
			maxHeapify(position, currentHeapSize);
		}
	}
}

public class HeapSort {
	public void performHeapSort(MaxHeap maxHeap) {
		for(int j= (maxHeap.heapSize-1)/2;j>=0;j--) {
			maxHeap.maxHeapify(j,maxHeap.heapSize);
		}

		int position = maxHeap.heapSize-1;
		for(;position>=0;) {
			maxHeap.swapHeapElements(0,position);
			maxHeap.maxHeapify(0, position);
			position -= 1;
		}

		for(int i=0;i<maxHeap.heapSize;i++) {
			System.out.print(maxHeap.heapArray[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfElements = in.nextInt();

		MaxHeap maxHeap = new MaxHeap(noOfElements);
		for(int i=0;i<noOfElements;i++) {
			maxHeap.insertHeapElement(in.nextInt());
		}

		HeapSort heapSort = new HeapSort();
		heapSort.performHeapSort(maxHeap);
	}
}
