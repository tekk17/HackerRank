package problems;

public class DistanceBetweenNodesLCA {
	public static Node findLCAInBinaryTree(Node node, int n1, int n2) {
		if(node == null) {
			return null;
		}

		if(node.data == n1 || node.data == n2) {
			return node;
		}

		Node leftLCA = findLCAInBinaryTree(node.left,n1,n2);
		Node rightLCA = findLCAInBinaryTree(node.right,n1,n2);

		if(leftLCA != null && rightLCA != null) {
			return node;
		}

		return(leftLCA!= null?leftLCA:rightLCA);
	}

	public static int findLevel(Node node, int key, int level) {
		if(node == null) {
			return -1;
		}

		if(node.data == key) {
			return level;
		}

		int distance = findLevel(node.left,key,level+1);
		return (distance == -1)?findLevel(node.right,key, level+1):distance;
	}

	public static boolean findCommonNodes(Node head, int info) {
		if(head == null) return false;
		if(head.data == info) {
			System.out.print(info + " ");
			return true;
		}

		if(findCommonNodes(head.left,info) || findCommonNodes(head.right,info)) {
			System.out.print(head.data + " ");
		}

		return false;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node rootLeft = new Node(2);
		Node rootRight = new Node(3);
		Node rootLeftLeft = new Node(4);
		Node rootLeftRight = new Node(5);
		Node rootRightLeft = new Node(6);
		Node rootRightRight = new Node(7);

		root.addLink(rootLeft,rootRight);
		rootLeft.addLink(rootLeftLeft,rootLeftRight);
		rootRight.addLink(rootRightLeft,rootRightRight);

		Node lca1 = findLCAInBinaryTree(root,4,5);
		Node lca2 = findLCAInBinaryTree(root,5,7);

		System.out.print(lca1.data + " " + lca2.data);

		int distance1 = findLevel(lca1, 4, 0);
		int distance2 = findLevel(lca1, 5, 0);
		int distance3 = findLevel(lca2, 5, 0);
		int distance4 = findLevel(lca2, 7,0);
		System.out.println("\n" + (distance1+distance2) + " " + (distance3+distance4));

		findCommonNodes(root,lca1.data);
		findCommonNodes(root,lca2.data);

	}
}
