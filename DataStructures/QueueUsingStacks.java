package problems;

import java.util.Scanner;

public class QueueUsingStacks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int noOfOperation = in.nextInt();
		int[] elements = new int[noOfOperation];
		int front = -1;
		int rear = -1;
		
		for (int i=0;i<noOfOperation;i++) {
			int operation = in.nextInt();
			if (operation == 1) {
				//enqueue
				int element = in.nextInt();
				if (front == -1) {
					elements[++front] = element;
					rear += 1;
				} else {
					elements[++front] = element;
				}
				
			} else if (operation == 2) {
				//dequeue
				if (front == rear) {
					rear = -1;
					front = -1;
				} else if (rear != -1) {
					rear += 1;
				}
			} else if (operation == 3) {
				//print element
				if (rear != -1) {
					System.out.println(elements[rear]);
				}
			}
		}
		
		in.close();
	}

}
