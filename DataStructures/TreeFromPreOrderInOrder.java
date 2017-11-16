package problems;

import java.util.Scanner;

class TreeNode {
	char data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(char item) {
		this.data = item;
		this.left = null;
		this.right = null;
	}
}
public class TreeFromPreOrderInOrder {
	public static int preOrderIndex = 0;
	
	public static TreeNode buildTree(char[] pre,char[] in, int start, int end) {
		if(start > end) return null;
		
		TreeNode treeNode = new TreeNode(pre[preOrderIndex++]);
		
		if(start == end) return treeNode;
		
		int elementIndex = searchIndex(in, start, end, treeNode.data);
		
		treeNode.left = buildTree(pre, in, start, elementIndex-1);
		treeNode.right = buildTree(pre, in, elementIndex+1, end);
		
		return treeNode;
	}
	
	public static int searchIndex(char[] elements, int startIndex, int endIndex, char value) {
		int index = -1;
		for(int i=startIndex;i<=endIndex;i++) {
			if(elements[i] == value) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static void inOrder(TreeNode treeNode) {
		if(treeNode != null) {
			inOrder(treeNode.left);
			System.out.print(treeNode.data + " ");
			inOrder(treeNode.right);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		String inOrderString = in.next();
		String preOrderString = in.next();
		char[] inOrder = new char[length];
		inOrder = inOrderString.toCharArray();
		char[] preOrder = new char[length];
		preOrder = preOrderString.toCharArray();
		
		TreeNode rootNode = buildTree(preOrder, inOrder, 0, length-1);
		
		inOrder(rootNode);
		
		in.close();
	}
}
