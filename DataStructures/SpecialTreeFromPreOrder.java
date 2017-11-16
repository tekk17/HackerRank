package problems;

import java.util.Scanner;

class MyIndex {
	int index = 0;
}
public class SpecialTreeFromPreOrder {
	TreeNodeInt root;
	MyIndex myIndex = new MyIndex();
	
	public static TreeNodeInt buildSpecialTree(int[] pre,char[] preChars,MyIndex myInd, int n, TreeNodeInt temp) {
		int index = myInd.index;
		
		if(index == n) return null;
		
		temp = new TreeNodeInt(pre[index]);
		myInd.index++;
		
		if(preChars[index] == 'N') {
			temp.left = buildSpecialTree(pre,preChars,myInd,n,temp.left);
			temp.right = buildSpecialTree(pre,preChars,myInd,n,temp.right);
		}
		return temp;
	}
	
	public static void inOrder(TreeNodeInt start) {
		if(start != null) {
			inOrder(start.left);
			System.out.print(start.data + " ");
			inOrder(start.right);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int[] preOrder = new int[number];
		String preString = new String();
		char[] preChars = new char[number];
		
		for(int i=0;i<number;i++) {
			preOrder[i] = in.nextInt();
		}
		
		preString = in.next();
		preChars = preString.toCharArray();
		
		SpecialTreeFromPreOrder start = new SpecialTreeFromPreOrder();
		start.root = buildSpecialTree(preOrder, preChars, start.myIndex, number, start.root);
		
		inOrder(start.root);
		
		in.close();
	}
}
