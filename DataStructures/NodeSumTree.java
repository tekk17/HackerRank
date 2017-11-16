package problems;

public class NodeSumTree {
	public static int convertToNodeSumTree(TreeNodeInt start) {
		if(start == null) return 0;

		int oldValue = start.data;

		start.data = convertToNodeSumTree(start.left) + convertToNodeSumTree(start.right);

		return start.data + oldValue;
	}

	public static void sumInOrder(TreeNodeInt start) {
		if(start != null) {
			sumInOrder(start.left);
			System.out.print(start.data + " ");
			sumInOrder(start.right);
		}
	}
}
