package problems;

public class LeftRightTreeToDownRightTree {
	public static void ConvertLeftRightToDownRight(Node start) {
		if(start == null) return;

		ConvertLeftRightToDownRight(start.left);
		ConvertLeftRightToDownRight(start.right);

		if(start.left == null) {
			start.left = start.right;
		} else {
			start.left.right = start.right;
		}
		start.right = null;
	}

	public static void DownRightTraversal(Node start) {
		if(start != null) {
			System.out.print(start.data + " ");
			DownRightTraversal(start.right);
			DownRightTraversal(start.left);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		Node rootLeft = new Node(2);
		Node rootRight = new Node(3);
		Node rootRightLeft = new Node(4);
		Node rootRightRight = new Node(5);
		Node rootRightLeftLeft = new Node(6);
		Node rootRightRightLeft = new Node(7);
		Node rootRightRightRight = new Node(8);
		
		root.addLink(rootLeft,rootRight);
		rootRight.addLink(rootRightLeft,rootRightRight);
		rootRightLeft.addLink(rootRightLeftLeft,null);
		rootRightRight.addLink(rootRightRightLeft,rootRightRightRight);

		ConvertLeftRightToDownRight(root);
		DownRightTraversal(root);
	}
}
