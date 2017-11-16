package problems;

public class BinaryTreeWithLogicalAnd {
	public static void convertToLogicalAnd(Node start) {
		if(start != null) {
			convertToLogicalAnd(start.left);
			convertToLogicalAnd(start.right);
			if(start.left != null && start.right != null) {
				start.data = start.left.data & start.right.data;
			}
		}
	}

	public static void inOrderLogicalAnd(Node start) {
		if(start != null) {
			inOrderLogicalAnd(start.left);
			System.out.print(start.data + " ");
			inOrderLogicalAnd(start.right);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node rootLeft = new Node(1);
		Node rootRight = new Node(0);
		Node rootLeftLeft = new Node(0);
		Node rootLeftRight = new Node(1);
		Node rootRightLeft = new Node(1);
		Node rootRightRight = new Node(1);

		root.addLink(rootLeft,rootRight);
		rootLeft.addLink(rootLeftLeft,rootLeftRight);
		rootRight.addLink(rootRightLeft,rootRightRight);

		convertToLogicalAnd(root);
		inOrderLogicalAnd(root);
	}
}
