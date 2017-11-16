package problems;

import java.util.Scanner;

class DoublyLinkedList {
	int info;
	DoublyLinkedList prev;
	DoublyLinkedList next;
	
	public DoublyLinkedList(int data) {
		this.info = data;
		this.prev = null;
		this.next = null;
	}
}

class TreeNodeInt {
	int data;
	TreeNodeInt left;
	TreeNodeInt right;
	
	TreeNodeInt(int info) {
		this.data = info;
		this.left = null;
		this.right = null;
	}
}

public class TreeFromInOrderLevelOrder {
	
	public static int inOrderIndex = 0;
	
	public static TreeNodeInt buildTreeFromInOrderLevelOrder(TreeNodeInt treeNode,int[] in, int[] level, int start, int end) {
		if(start > end) return null;
		
		if(start == end) {
			return new TreeNodeInt(in[start]);
		}

		boolean found = false;
		int index = 0;

		for(int i=0;i<level.length;i++) {
			int data = level[i];
			for(int j=start;j<=end;j++) {
				if(data == in[j]) {
					index = j;
					treeNode = new TreeNodeInt(data);
					found = true;
					break;
				}
			}
			if(found) {
				break;
			}
		}
		
		treeNode.left = buildTreeFromInOrderLevelOrder(treeNode, in, level, start, index-1);
		treeNode.right = buildTreeFromInOrderLevelOrder(treeNode, in, level, index+1, end);
		
		return treeNode;
		
	}
	
	public static int searchIndexInInorderOrder(int[] levelTraversal,int first,int last,int value) {
		int index = -1;
		for(int i=first;i<=last;i++) {
			if(levelTraversal[i] == value) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static void InorderTraversal(TreeNodeInt start) {
		if(start != null) {
			InorderTraversal(start.left);
			System.out.print(start.data + " ");
			InorderTraversal(start.right);
		}
	}

	/*
	Construct Doubly Linked List From A Binary Tree
	 */
	public static TreeNodeInt constructDLLFromTreeInOrder(TreeNodeInt start) {
		if(start == null) {
			return start;
		}
		
		if(start.left != null) {
			TreeNodeInt left = constructDLLFromTreeInOrder(start.left);
			for(;left.right != null;left=left.right);
			
			left.right = start;
			start.left = left;
		}
		
		if(start.right != null) {
			TreeNodeInt right = constructDLLFromTreeInOrder(start.right);
			for(;right.left != null;right=right.left);
			
			right.left = start;
			start.right = right;
		}
		return start;
	}
	
	public static TreeNodeInt constructDLLFromTreeUtil(TreeNodeInt start) {
		if(start == null) return start;
		
		TreeNodeInt root = constructDLLFromTreeInOrder(start);
		
		while(root.left != null) {
			root = root.left;
		}
		
		return root;
	}
	
	public static void printDLL(TreeNodeInt start) {
		while(start != null) {
			System.out.print(start.data + " ");
			start = start.right;
		}
	}

	/*
	Convert Tree DLL Into A Tree Circular Linked List
	 */
	public static TreeNodeInt convertDLLToCLL(TreeNodeInt start) {
		TreeNodeInt last = null;
		TreeNodeInt current = start;

		while(current.right != null) {
			current = current.right;
		}
		last = current;
		start.left = last;
		last.right = start;

		return start;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfNodes = in.nextInt();
		int[] inOrder = new int[numberOfNodes];
		int[] levelOrder = new int[numberOfNodes];
		
		for(int i=0;i<numberOfNodes;i++) {
			inOrder[i] = in.nextInt();
		}
		
		for(int i=0;i<numberOfNodes;i++) {
			levelOrder[i] = in.nextInt();
		}

		TreeNodeInt start = null;
		TreeNodeInt treeNode = buildTreeFromInOrderLevelOrder(start, inOrder, levelOrder, 0, numberOfNodes-1);
		
		InorderTraversal(treeNode);

		System.out.println();
		
		TreeNodeInt dllNode = constructDLLFromTreeUtil(treeNode);
		
		printDLL(dllNode);

		convertDLLToCLL(dllNode);
		
		
		in.close();
	}
}
