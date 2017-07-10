package problems;

import java.util.Scanner;

class AVLTrees {
	public static AVLTrees root = null;
	public int info;
	public int heightOfNode;
	public AVLTrees leftNode;
	public AVLTrees rightNode;

	public static AVLTrees AVLTreesInsertInTree(AVLTrees start, int info ) {
		if (start == null) {
			AVLTrees newNode = new AVLTrees();
			newNode.info = info;
			newNode.heightOfNode = 0;
			newNode.leftNode = null;
			newNode.rightNode = null;
			return newNode;
		}
		
		if(info < start.info) {
			start.leftNode = AVLTreesInsertInTree(start.leftNode, info);
		} else if (info > start.info) {
			start.rightNode = AVLTreesInsertInTree(start.rightNode, info);
		} else {
			return start;
		}
		
		start.heightOfNode = height(start);
		
		int balancingFactor = balancingFactor(start);
		
		if (balancingFactor > 1 && info < start.leftNode.info) {
			return rightRotation(start);
		} else if (balancingFactor > 1 && info > start.leftNode.info) {
			start.leftNode = leftRotation(start.leftNode);
			return rightRotation(start);
		} else if (balancingFactor < -1 && info > start.rightNode.info) {
			return leftRotation(start);
		} else if (balancingFactor < -1 && info < start.rightNode.info) {
			start.rightNode = rightRotation(start.rightNode);
			return leftRotation(start);
		}
			
		return start;
	}

	public static int height(AVLTrees head) {
		if (head == null)
			return -1;;
		int val1 = height(head.leftNode);
		int val2 = height(head.rightNode);
		return 1 + ((val1 > val2) ? val1 : val2);
	}
	
	public static int balancingFactor(AVLTrees head) {
		if (head == null)
			return 0;
		int val1 = height(head.leftNode);
		int val2 = height(head.rightNode);
		return (val1-val2);
	}

	public static AVLTrees rightRotation(AVLTrees node) {
		AVLTrees q = node.leftNode;
		AVLTrees hold = q.rightNode;
		q.rightNode = node;
		node.leftNode = hold;
		
		q.heightOfNode = height(q);	
		node.heightOfNode = height(node);
		
		return q;
	}

	public static AVLTrees leftRotation(AVLTrees node) {
		AVLTrees q = node.rightNode;
		AVLTrees hold = q.leftNode;
		q.leftNode = node;
		node.rightNode = hold;
		
		q.heightOfNode = height(q);
		node.heightOfNode = height(node);
		
		return q;
	}
	
	public static void inOrderTraversal(AVLTrees start) {
		if (start != null) {
			inOrderTraversal(start.leftNode);
			System.out.print(start.info + " ");
			inOrderTraversal(start.rightNode);
		}
	}
	
	public static void postOrderTraversal(AVLTrees start) {
		if (start != null) {
			postOrderTraversal(start.leftNode);
			postOrderTraversal(start.rightNode);
			System.out.print(start.info + " ");
		}
	}

	public static void main(String[] args) {
		boolean isFirstNode = false;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the no.of nodes in the tree : " );
		int noOfElements = in.nextInt();
		int[] elements = new int[noOfElements];
		
		for(int i=0;i<noOfElements;i++) {
			elements[i] = in.nextInt();
		}

		for (int i = 0; i < noOfElements; i++) {
			if (!isFirstNode) {
				root = new AVLTrees();
				root.info = elements[i];
				root.heightOfNode = 0;
				root.leftNode = null;
				root.rightNode = null;
				isFirstNode = true;
				continue;
			}
			root = AVLTreesInsertInTree(root, elements[i]);
		}
		
		inOrderTraversal(root);
		System.out.println();
		postOrderTraversal(root);

		in.close();
	}
}
