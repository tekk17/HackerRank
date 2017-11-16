package problems;

import problems.TreeNodeInt;

import java.util.ArrayList;
import java.util.Scanner;

class LinkedList {
	int data;
	LinkedList link = null;
	
	LinkedList(int info) {
		this.data = info;
		this.link = null;
	}
}

public class BinaryTreeFromLinkedList {
	
	public static int count = 0;
	
	public static TreeNodeInt buildTreeFromList(int[] numbers,int length) {
		ArrayList<TreeNodeInt> nodeList = new ArrayList<TreeNodeInt>();
		if(length == -1) return null;
		
		TreeNodeInt root = new TreeNodeInt(numbers[0]);
		
		if(length == 0) {
			return root;
		}
		
		nodeList.add(root);
		int top = -1;
		int i=0;
		
		while(i<length) {
			TreeNodeInt currNode = nodeList.get(++top);
			i = (2*top)+1;
			if(i<length) {
				TreeNodeInt leftNode = new TreeNodeInt(numbers[i]);
				nodeList.add(leftNode);
				currNode.left = leftNode;
			} else {
				break;
			}
			i = (2*top)+2;
			if(i<length) {
				TreeNodeInt rightNode = new TreeNodeInt(numbers[i]);
				nodeList.add(rightNode);
				currNode.right = rightNode;
			} else {
				break;
			}
		}
		
		return root;
	}
	
	public static TreeNodeInt findNode(TreeNodeInt start,int info) {
		while(start != null) {
			if(info == start.data) {
				return start;
			} else if(info>start.data) {
				start = start.right;
			} else if(info < start.data) {
				start = start.left;
			}
		}
		return start;
	}
	
	public static void inOrder(TreeNodeInt head) {
		if(head != null) {
			inOrder(head.left);
			System.out.print(head.data + " ");
			inOrder(head.right);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfElements = in.nextInt();
		int[] elements = new int[numberOfElements];
		
		for(int i=0;i<numberOfElements;i++) {
			elements[i] = in.nextInt();
		}
		
		TreeNodeInt root = buildTreeFromList(elements, numberOfElements);
		
		inOrder(root);
		
		in.close();
	}
}
