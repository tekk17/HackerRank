package problems;

public class SumOfLeftNodesBinaryTree {
	public int convertToSumOfLeftNode(Node start) {
		if(start == null) return 0;
		
		if(start.left == null && start.right == null) return start.data;
		
		int leftData = convertToSumOfLeftNode(start.left);
		int rightData = convertToSumOfLeftNode(start.right);
		
		start.data += leftData;
		
		return start.data+rightData;
	}
	
	public void inOrderSumOfLeftNode(Node start) {
		if(start != null) {
			inOrderSumOfLeftNode(start.left);
			System.out.print(start.data + " ");
			inOrderSumOfLeftNode(start.right);
		}
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

		SumOfLeftNodesBinaryTree current = new SumOfLeftNodesBinaryTree();
		int sum = current.convertToSumOfLeftNode(root);
		System.out.println(sum);
		current.inOrderSumOfLeftNode(root);
	}
}
