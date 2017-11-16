package problems;

public class LowestCommonAncestorBST {
	public static Node findLCAInBST(Node start, int data1, int data2) {
		if(start == null) return null;

		if(start.data > data1 && start.data > data2) {
			return findLCAInBST(start.left, data1, data2);
		}

		if(start.data < data1 && start.data < data2) {
			return findLCAInBST(start.right,data1,data2);
		}
		return start;
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		Node rootLeft = new Node(8);
		Node rootRight = new Node(22);
		Node rootLeftLeft = new Node(4);
		Node rootLeftRight = new Node(12);
		Node rootLeftRightLeft = new Node(10);
		Node rootLeftRightRight = new Node(14);

		root.addLink(rootLeft,rootRight);
		rootLeft.addLink(rootLeftLeft,rootLeftRight);
		rootLeftRight.addLink(rootLeftRightLeft,rootLeftRightRight);

		Node LCA1 = findLCAInBST(root,4,14);
		System.out.println(LCA1.data);

		Node LCA2 = findLCAInBST(root,10,14);
		System.out.println(LCA2.data);
	}
}
