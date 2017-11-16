package problems;

class InOrderSuccessorNodes {
	int data;
	InOrderSuccessorNodes left;
	InOrderSuccessorNodes right;
	InOrderSuccessorNodes next;

	InOrderSuccessorNodes(int info) {
		this.data = info;
		this.left = null;
		this.right = null;
		this.next = null;
	}

	public void addLink(InOrderSuccessorNodes leftChild, InOrderSuccessorNodes rightChild) {
		this.left = leftChild;
		this.right = rightChild;
	}
}

public class InOrderSuccessorForNodes {

	public static InOrderSuccessorNodes current = null;

	public static void populateInOrderSuccessors(InOrderSuccessorNodes start) {
		if(start != null) {
			populateInOrderSuccessors(start.right);

			start.next = current;
			current = start;

			populateInOrderSuccessors(start.left);
		}
	}

	public static void printInOrderSuccessorTraversal(InOrderSuccessorNodes start) {
		if(start != null) {
			printInOrderSuccessorTraversal(start.right);
			System.out.print(start.data + " ");
			printInOrderSuccessorTraversal(start.left);
		}
	}


	public static void main(String[] args) {
		InOrderSuccessorNodes root = new InOrderSuccessorNodes(20);
		InOrderSuccessorNodes rootLeft = new InOrderSuccessorNodes(8);
		InOrderSuccessorNodes rootRight = new InOrderSuccessorNodes(22);
		InOrderSuccessorNodes rootLeftLeft = new InOrderSuccessorNodes(4);
		InOrderSuccessorNodes rootLeftRight = new InOrderSuccessorNodes(12);
		InOrderSuccessorNodes rootLeftRightLeft = new InOrderSuccessorNodes(10);
		InOrderSuccessorNodes rootLeftRightRight = new InOrderSuccessorNodes(14);

		root.addLink(rootLeft,rootRight);
		rootLeft.addLink(rootLeftLeft,rootLeftRight);
		rootLeftRight.addLink(rootLeftRightLeft,rootLeftRightRight);

		populateInOrderSuccessors(root);

		printInOrderSuccessorTraversal(root);
	}
}
