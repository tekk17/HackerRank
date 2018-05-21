package dataStructures;

import java.util.Scanner;

class SwapTreeNodes {
	int info;
	SwapTreeNodes left;
	SwapTreeNodes right;
	
	SwapTreeNodes(int info) {
		this.info = info;
		this.left = null;
		this.right = null;
	}
	
	public SwapTreeNodes addSwapNodes(SwapTreeNodes currNode, int leftData, int rightData) {
		SwapTreeNodes currLeftNode = null;
		SwapTreeNodes currRightNode = null;
		if (leftData != -1) {
			currLeftNode = new SwapTreeNodes(leftData);
		} 
		
		if (rightData != -1) {
			currRightNode = new SwapTreeNodes(rightData);
		}
		
		currNode.updateLinks(currNode, currLeftNode, currRightNode);
		
		return currNode;
	}
	
	public void updateLinks(SwapTreeNodes parent, SwapTreeNodes leftChild, SwapTreeNodes rightChild) {
		parent.left = leftChild;
		parent.right = rightChild;
	}
	
	public SwapTreeNodes findNode(SwapTreeNodes current, int data) {
		if (current != null) {
			if (current.info == data) {
				return current;
			}
			SwapTreeNodes foundNode = findNode(current.left,data);
			if (foundNode == null) {
				foundNode = findNode(current.right,data);
			} 
			return foundNode;
		} else {
			return null;
		}
	}
	
	public int height(SwapTreeNodes root) {
        if (root == null) return -1;
        int val1 = height(root.left);
        int val2 = height(root.right);
        return 1+((val1>val2)?val1:val2);
    }
	
	public void levelOrder(SwapTreeNodes head, int base) {
		if (head != null) {
			if (base == 1) {
				//call to swap
				swapNode(head);
				//return head;
			}
			if (base>1) {
				levelOrder(head.left,base-1);
				levelOrder(head.right,base-1);
			}
		}
		//return null;
	}
	
	public void swapNode(SwapTreeNodes parentNode) {
		if(parentNode != null) {
			SwapTreeNodes swapChild = null;
			if (parentNode.left != null) {
				swapChild = parentNode.left;
			}
			parentNode.left = parentNode.right;
			parentNode.right = swapChild;
		}
	}
	
	public void inorderTraversal(SwapTreeNodes head) {
		if (head != null) {
			inorderTraversal(head.left);
			System.out.print(head.info + " ");
			inorderTraversal(head.right);
		}
	}

//public class SwapTreeNodes {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);;
		int noOfNodes = in.nextInt();
		
		int nodeInfo[][] = new int[noOfNodes][2];
		for(int i=0;i<noOfNodes;i++) {
			for(int j=0;j<=1;j++) {
				nodeInfo[i][j] = in.nextInt();
			}
		}
		int noOfSwaps = in.nextInt();;
		int swapInfo[] = new int[noOfSwaps];
		for(int k=0;k<noOfSwaps;k++) {
			swapInfo[k] = in.nextInt();
		}
		
		//i variable for 2^i;start from 2^i for 2^i time;divide=2^i/2;1 to div go left;div+1toend go right
		SwapTreeNodes root = new SwapTreeNodes(1);
		SwapTreeNodes currPtr = root;
		
		for(int i=0;i<noOfNodes;i++) {
			//currPtr = root;
			currPtr = currPtr.findNode(root, i+1);
			currPtr.addSwapNodes(currPtr, nodeInfo[i][0], nodeInfo[i][1]);
		}
		
		int heightOfTree = root.height(root);
		heightOfTree += 1; 
		
		for(int k=0;k<noOfSwaps;k++){
			int swap = swapInfo[k];
			int increment = 2;
			currPtr = root;
			while(swap<=heightOfTree) {
				currPtr.levelOrder(currPtr,swap);
				swap = swapInfo[k]*increment;
				increment++;
			}
			root.inorderTraversal(root);
			System.out.print("\n");
		}
		
		//root.inorderTraversal(root);
		
		in.close();
	}
}
