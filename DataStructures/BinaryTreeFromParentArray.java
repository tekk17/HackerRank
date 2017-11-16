package problems;

import java.util.Scanner;

public class BinaryTreeFromParentArray {
	
	public static TreeNodeInt buildTreeFromParentArray(int[] nodes,int value,int length,int counter) {
		if(length == 0) {
			TreeNodeInt current = new TreeNodeInt(nodes[0]);
			return current;
		}
		
		if(counter == -1) return null;
		
		TreeNodeInt temp = new TreeNodeInt(value);
		
		int[] indices = new int[2];
		indices = searchIndex(nodes,temp.data,length);
		
		if(indices[0] != -1) {
			temp.left = buildTreeFromParentArray(nodes,indices[0], length,counter-1);
		}
		if(indices[1] != -1) {
			temp.right = buildTreeFromParentArray(nodes,indices[1], length, counter-1);
		}
		return temp;
		
	}
	
	public static int[] searchIndex(int[] dataInfo,int value,int len) {
		int[] returnVal = {-1,-1};
		int top = -1;
		for(int i=0;i<len;i++) {
			if(dataInfo[i] == value) returnVal[++top] = i;
		}
		return returnVal;
	}
	
	public static void InOrder(TreeNodeInt start) {
		if(start != null) {
			InOrder(start.left);
			System.out.print(start.data + " ");
			InOrder(start.right);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfElements = in.nextInt();
		int[] nodeInfo = new int[noOfElements];
		int parentIndex = -1;
		
		for(int i=0;i<noOfElements;i++) {
			nodeInfo[i] = in.nextInt();
			if(nodeInfo[i] == -1) {
				parentIndex = i;
			}
		}
		
		TreeNodeInt root = new TreeNodeInt(parentIndex);
		int counter = noOfElements;
		root = buildTreeFromParentArray(nodeInfo, parentIndex, noOfElements, counter);
		InOrder(root);
		in.close();
	}
}
