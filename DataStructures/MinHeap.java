package dataStructures;

import java.util.Scanner;

public class MinHeap {
	int[] heapArray;
	int capacity;
	int heapSize;

	MinHeap(int cap) {
		capacity = cap+1;
		heapSize = 0;
		heapArray = new int[capacity];
	}

	public int parentPosition(int position) {
		return ((position-1)/2);
	}

	public int parentLeftChild(int position) {
		return ((position * 2)+1);
	}

	public int parentRightChild(int position) {
		return ((position * 2)+2);
	}

	public void swapPositions(int position1, int position2) {
		int temp = heapArray[position1];
		heapArray[position1] = heapArray[position2];
		heapArray[position2] = temp;
	}

	public void insertElement(int element) {
		if(heapSize == capacity+1) {
			return;
		}
		int position = heapSize;
		heapArray[position] = element;
		heapSize += 1;

		while (position > 0 && (heapArray[position] < heapArray[parentPosition(position)])) {
			int parent = parentPosition(position);
			swapPositions(position,parentPosition(position));
			position = parent;
		}
	}

	public void replaceElement(int position, int element) {
		heapArray[position] = element;
		int newPosition = parentPosition(position);
		while(position != 0 && (heapArray[parentPosition(position)] > heapArray[position])) {
			swapPositions(position,parentPosition(position));
			position = parentPosition(position);
		}
	}

	public void minHeapify(int position) {
		int leftChildPosition = parentLeftChild(position);
		int rightChildPosition = parentRightChild(position);
		int smallest = position;

		if(leftChildPosition < heapSize && heapArray[leftChildPosition] < heapArray[position]) {
			smallest = leftChildPosition;
		}
		if(rightChildPosition < heapSize && heapArray[rightChildPosition] < heapArray[smallest]) {
			smallest = rightChildPosition;
		}
		if(smallest != position) {
			swapPositions(smallest, position);
			minHeapify(smallest);
		}
	}

	public int removeRootElement() {
		if(heapSize <= 0) {
			return Integer.MAX_VALUE;
		}
		if(heapSize == 1) {
			heapSize -= 1;
			return heapArray[heapSize];
		}

		int rootElement = heapArray[0];
		heapArray[0] = heapArray[heapSize-1];
		heapSize -= 1;
		minHeapify(0);
		return rootElement;
	}

	public void deleteElement(int position) {
		replaceElement(position, Integer.MIN_VALUE);
		removeRootElement();
	}

	public void printHeap() {
		for(int i=0;i<heapSize/2;i++) {
			int leftChildPosition = parentLeftChild(i);
			int rightChildPosition = parentRightChild(i);
			System.out.print("Parent: " + heapArray[i]);
			if (leftChildPosition < heapSize) {
				System.out.print(" LeftChild: " + heapArray[leftChildPosition]);
			}
			if(rightChildPosition < heapSize) {
				System.out.print(" RightChild: " + heapArray[rightChildPosition]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfNodes = in.nextInt();

		MinHeap binaryHeap = new MinHeap(noOfNodes);
		for(int i=0;i<noOfNodes;i++) {
			binaryHeap.insertElement(in.nextInt());
		}
		binaryHeap.printHeap();
		binaryHeap.minHeapify(0);
		binaryHeap.printHeap();
		binaryHeap.deleteElement(2);
		binaryHeap.printHeap();
	}
}
