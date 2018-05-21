package dataStructures;

class Values {
	int min;
	int max;
}
public class VerticalOrderViewBinaryTree {
	Node root;

	Values value = new Values();

	public void findMinMaxHorizontalDistance(Node start, Values min, Values max, int hd) {
		if(start == null) return;

		if(hd < min.min) min.min = hd;

		if(hd > max.max) max.max = hd;

		findMinMaxHorizontalDistance(start.left,min,max,hd-1);
		findMinMaxHorizontalDistance(start.right,min,max,hd+1);
	}

	public void printVerticalOrder(Node start, int line, int hd) {
		if(start == null) return;

		if(line == hd) System.out.print(start.data + " ");

		printVerticalOrder(start.left,line, hd-1);
		printVerticalOrder(start.right,line,hd+1);
	}

	public void VerticalOderView(Node start) {
		if(start == null) return;

		findMinMaxHorizontalDistance(start,value,value,0);

		for(int i=value.min;i<=value.max;i++) {
			printVerticalOrder(start,i,0);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		VerticalOrderViewBinaryTree tree = new VerticalOrderViewBinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);

		tree.VerticalOderView(tree.root);

	}
}
