package problems;

import java.util.Scanner;
import java.util.Stack;

class CharNode{
	char letter;
	CharNode left;
	CharNode right;
	
	CharNode(char alphabet) {
		this.letter = alphabet;
		this.left = null;
		this.right = null;
	}
}
public class TernaryExpToBinaryTree {
	public static CharNode convertTernaryToBinaryTree(char[] expression) {
		Stack<CharNode> nodeStack = new Stack<>();
		CharNode root = new CharNode(expression[0]);
		nodeStack.push(root);

		for(int i=1;i<expression.length;i++) {
			if(expression[i] == '?') {
				CharNode first = nodeStack.peek();
				first.left = new CharNode(expression[i+1]);
				nodeStack.push(first.left);
			} else if(expression[i] == ':') {
				nodeStack.pop();
				CharNode first = nodeStack.pop();
				first.right = new CharNode(expression[i+1]);
				nodeStack.push(first.right);
			}
		}
		return root;
	}

	public static void TernaryTreeTraversalInorder(CharNode start) {
		if(start != null) {
			TernaryTreeTraversalInorder(start.left);
			System.out.print(start.letter + " ");
			TernaryTreeTraversalInorder(start.right);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String exp = in.next();
		char[] expression = new char[exp.length()];
		expression = exp.toCharArray();

		CharNode root = convertTernaryToBinaryTree(expression);

		TernaryTreeTraversalInorder(root);
		in.close();
	}
}
