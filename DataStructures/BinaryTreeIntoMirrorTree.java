package problems;

public class BinaryTreeIntoMirrorTree {
	public Node convertBinaryToMirror(Node start) {
		if(start == null) return start;

		Node left = convertBinaryToMirror(start.left);
		Node right = convertBinaryToMirror(start.right);

		start.left = right;
		start.right = left;

		return start;
	}

	public static void inOrderMirror(Node start) {
		if(start != null) {
			inOrderMirror(start.left);
			System.out.print(start.data + " ");
			inOrderMirror(start.right);
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

		BinaryTreeIntoMirrorTree current = new BinaryTreeIntoMirrorTree();
		System.out.print("InOrder Traversal Before Mirroring :");
		inOrderMirror(root);
		Node newRoot = current.convertBinaryToMirror(root);
		System.out.print("\nInOrder Traversal Before Mirroring :");
		inOrderMirror(newRoot);
	}
}
