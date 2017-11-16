package problems;

class ThreadedNode {
	int data;
	ThreadedNode left;
	ThreadedNode right;
	boolean isThreaded;

	ThreadedNode(int info) {
		this.data = info;
		this.left = null;
		this.right = null;
		isThreaded = false;
	}

	public void addThreadedNode(ThreadedNode leftLink, ThreadedNode rightLink) {
		this.left = leftLink;
		this.right = rightLink;
	}
}
public class ThreadedBinaryTree {
	public static ThreadedNode constructThreadedBinaryTree(ThreadedNode start) {
		if(start == null) return null;
		if (start.left == null && (start.right == null)) {
			return start;
		}
		if(start.left != null) {
			ThreadedNode startLeft = constructThreadedBinaryTree(start.left);
			startLeft.right = start;
			startLeft.isThreaded = true;
		}
		if(start.right == null) return start;
		return constructThreadedBinaryTree(start.right);
	}

	public ThreadedNode findLeftMostChild(ThreadedNode start) {
		while(start != null && (start.left != null)) {
			start = start.left;
		}
		return start;
	}

	public void printThreadedInOrder(ThreadedNode start) {
		if(start == null) return;

		ThreadedNode currentNode = findLeftMostChild(start);
		while(currentNode != null) {
			System.out.print(currentNode.data + " ");
			if(currentNode.isThreaded) {
				currentNode = currentNode.right;
			} else {
				currentNode = findLeftMostChild(currentNode.right);
			}
		}
	}

	public static void main(String[] args) {
		ThreadedBinaryTree current = new ThreadedBinaryTree();
		ThreadedNode root = new ThreadedNode(6);
		ThreadedNode rootLeft = new ThreadedNode(3);
		ThreadedNode rootLeftLeft = new ThreadedNode(1);
		ThreadedNode rootLeftRight = new ThreadedNode(5);
		ThreadedNode rootRight = new ThreadedNode(8);
		ThreadedNode rootRightLeft = new ThreadedNode(7);
		ThreadedNode rootRightRight = new ThreadedNode(11);
		ThreadedNode rootRightRightLeft = new ThreadedNode(9);
		ThreadedNode rootRightRightRight = new ThreadedNode(13);

		root.addThreadedNode(rootLeft,rootRight);
		rootLeft.addThreadedNode(rootLeftLeft,rootLeftRight);
		rootRight.addThreadedNode(rootRightLeft,rootRightRight);
		rootRightRight.addThreadedNode(rootRightRightLeft,rootRightRightRight);

		constructThreadedBinaryTree(root);
		current.printThreadedInOrder(root);
	}
}
