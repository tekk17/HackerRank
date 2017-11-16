package problems;

import java.util.Scanner;

public class SameBinaryTrees {
	public static boolean areTheTreesSame(Node root1,Node root2) {
		if(root1 == null && root2 == null) return true;

		if(root1 != null && root2 != null) {
			return (root1.data == root2.data && (areTheTreesSame(root1.left,root2.left)) && (areTheTreesSame(root1.right,root2.right)));
		}

		return false;
	}

	public static void main(String[] args) {
		Node root1 = new Node(1);
		Node root1Left = new Node(2);
		Node root1Right = new Node(3);

		root1.addLink(root1Left,root1Right);

		Node root2 = new Node(1);
		Node root2Left = new Node(2);
		Node root2Right = new Node(3);

		root2.addLink(root2Left,root2Right);

		if(areTheTreesSame(root1,root2)) {
			System.out.println("Trees are identical");
		} else {
			System.out.println("Trees are non-identical");
		}
	}
}
