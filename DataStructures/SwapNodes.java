package problems;

import java.util.Scanner;

class SwapNodes {
	int info;
	SwapNodes left;
	SwapNodes right;
	
	SwapNodes(int info) {
		this.info = info;
		this.left = null;
		this.right = null;
	}
	
	public SwapNodes addSwapNodes(SwapNodes currNode,int leftData,int rightData) {
		SwapNodes currLeftNode = null;
		SwapNodes currRightNode = null;
		if (leftData != -1) {
			currLeftNode = new SwapNodes(leftData);
		} 
		
		if (rightData != -1) {
			currRightNode = new SwapNodes(rightData);
		}
		
		currNode.updateLinks(currNode, currLeftNode, currRightNode);
		
		return currNode;
	}
	
	public void updateLinks(SwapNodes parent,SwapNodes leftChild,SwapNodes rightChild) {
		parent.left = leftChild;
		parent.right = rightChild;
	}
	
	public SwapNodes findNode(SwapNodes current,int data) {
		if (current != null) {
			if (current.info == data) {
				return current;
			}
			SwapNodes foundNode = findNode(current.left,data);
			if (foundNode == null) {
				foundNode = findNode(current.right,data);
			} 
			return foundNode;
		} else {
			return null;
		}
	}
	
	public int height(SwapNodes root) {
        if (root == null) return -1;
        int val1 = height(root.left);
        int val2 = height(root.right);
        return 1+((val1>val2)?val1:val2);
    }
	
	public void levelOrder(SwapNodes head,int base) {
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
	
	public void swapNode(SwapNodes parentNode) {
		if(parentNode != null) {
			SwapNodes swapChild = null;
			if (parentNode.left != null) {
				swapChild = parentNode.left;
			}
			parentNode.left = parentNode.right;
			parentNode.right = swapChild;
		}
	}
	
	public void inorderTraversal(SwapNodes head) {
		if (head != null) {
			inorderTraversal(head.left);
			System.out.print(head.info + " ");
			inorderTraversal(head.right);
		}
	}

//public class SwapNodes {
	
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
		SwapNodes root = new SwapNodes(1);
		SwapNodes currPtr = root;
		
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
