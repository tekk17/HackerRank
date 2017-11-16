package problems;

public class DiameterOfATree {
	public static int diameterOfATree(Node root) {
		if(root == null) return 0;

		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);

		int leftDiameter = diameterOfATree(root.left);
		int rightDiameter = diameterOfATree(root.right);

		return Math.max(leftHeight+rightHeight+1,Math.max(leftDiameter,rightDiameter));
	}

	public static int heightOfTree(Node start) {
		if(start == null) return 0;
		int left = heightOfTree(start.left);
		int right = heightOfTree(start.right);

		return (1+Math.max(left,right));
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node rootLeft = new Node(2);
		Node rootRight = new Node(3);
		Node rootLeftLeft = new Node(4);
		Node rootLeftRight = new Node(5);

		root.addLink(rootLeft,rootRight);
		rootLeft.addLink(rootLeftLeft,rootLeftRight);

		int value = diameterOfATree(root);

		System.out.println(value);
	}
}
