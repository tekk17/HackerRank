package dataStructures;

import java.util.*;
import java.util.LinkedList;

class BottomNode {
	int data;
	int hd;
	BottomNode left;
	BottomNode right;

	BottomNode(int info) {
		data = info;
		hd = Integer.MAX_VALUE;
		left = null;
		right = null;
	}


	public void addLink(BottomNode leftLink, BottomNode rightLink) {
		this.left = leftLink;
		this.right = rightLink;
	}
}

public class BottomViewBinaryTree {

	public void printBottomView(BottomNode start) {
		if(start == null) return;

		Queue<BottomNode> nodeQueue = new LinkedList<BottomNode>();
		Map<Integer,Integer> hdMap = new TreeMap<>();

		int hd = 0;

		start.hd = hd;

		nodeQueue.add(start);

		while(!nodeQueue.isEmpty()) {
			BottomNode newNode = nodeQueue.remove();

			hd = newNode.hd;
			hdMap.put(hd,newNode.data);

			if(newNode.left != null) {
				newNode.left.hd = hd - 1;
				nodeQueue.add(newNode.left);
			}

			if(newNode.right != null) {
				newNode.right.hd = hd + 1;
				nodeQueue.add(newNode.right);
			}
		}

		Set<Map.Entry<Integer,Integer>> set = hdMap.entrySet();
		Iterator<Map.Entry<Integer,Integer>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<Integer,Integer> printMap = iterator.next();
			System.out.print(printMap.getValue() + " ");
		}
	}

	public static void main(String[] args) {

		BottomNode root = new BottomNode(20);
        root.left = new BottomNode(8);
        root.right = new BottomNode(22);
        root.left.left = new BottomNode(5);
        root.left.right = new BottomNode(3);
        root.right.left = new BottomNode(4);
        root.right.right = new BottomNode(25);
        root.left.right.left = new BottomNode(10);
        root.left.right.right = new BottomNode(14);

		BottomViewBinaryTree tree = new BottomViewBinaryTree();
		tree.printBottomView(root);
	}
}
