package problems;

import java.util.ArrayList;
import java.util.logging.Level;

class LevelOrderNodes {
	int data;
	LevelOrderNodes left;
	LevelOrderNodes right;
	LevelOrderNodes adjacent;

	LevelOrderNodes(int info) {
		this.data = info;
		this.left = null;
		this.right = null;
		this.adjacent = null;
	}

	public void addLink(LevelOrderNodes leftChild, LevelOrderNodes rightChild) {
		this.left = leftChild;
		this.right = rightChild;
	}
}
public class LinkLevelOrderNodes {
	public static ArrayList<LevelOrderNodes> nodeList = new ArrayList<LevelOrderNodes>();
	public static int top = -1;

	public static int heightOfTree(LevelOrderNodes head) {
		if(head == null) return 0;
		int leftHeight = heightOfTree(head.left);
		int rightHeight = heightOfTree(head.right);

		return 1+Math.max(leftHeight,rightHeight);
	}

	public static void performLevelOrderTraversal(LevelOrderNodes head) {
		int height = heightOfTree(head);

		for(int i=0;i<=height;i++) {
			linkLevelOrderNodes(head, i);
		}
	}

	public static void linkLevelOrderNodes(LevelOrderNodes head, int i) {
		if(head == null) return;

		if(i == 0) {
			nodeList.add(head);
		}
		if(i > 0) {
			linkLevelOrderNodes(head.left,i-1);
			linkLevelOrderNodes(head.right,i-1);
		}
	}

	public static void main(String[] args) {
		LevelOrderNodes root = new LevelOrderNodes(10);
		LevelOrderNodes rootLeft = new LevelOrderNodes(8);
		LevelOrderNodes rootRight = new LevelOrderNodes(2);
		LevelOrderNodes rootLeftLeft = new LevelOrderNodes(3);
		LevelOrderNodes rootRightRight = new LevelOrderNodes(9);

		root.addLink(rootLeft,rootRight);
		rootLeft.addLink(rootLeftLeft,null);
		rootRight.addLink(null,rootRightRight);

		performLevelOrderTraversal(root);

		int length = nodeList.size();

		for(int i=0;i<length;i++) {
			System.out.print(nodeList.get(i).data + " ");
		}
	}
}
