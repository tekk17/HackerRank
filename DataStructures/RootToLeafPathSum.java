package problems;

public class RootToLeafPathSum {

	public static boolean hasPathEqualToSum(Node root, int sum) {
		if(root == null) {
			return (sum == 0);
		} else {
			boolean ans = false;
			int subSum = sum - root.data;
			if(subSum == 0 && root.left == null && root.right == null) {
				return true;
			}
			if(root.left != null) {
				ans = ans || hasPathEqualToSum(root.left,subSum);
			}
			if(root.right != null) {
				ans = ans || hasPathEqualToSum(root.right,subSum);
			}
			return ans;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		Node rootLeft = new Node(8);
		Node rootRight = new Node(2);
		Node rootLeftLeft = new Node(3);
		Node rootLeftRight = new Node(5);
		Node rootRightLeft = new Node(2);

		root.addLink(rootLeft,rootRight);
		rootLeft.addLink(rootLeftLeft,rootLeftRight);
		rootRight.addLink(rootRightLeft,null);

		if(hasPathEqualToSum(root,23)) {
			System.out.println("Path exists!");
		} else {
			System.out.println("Path does not exist.");
		}
	}
}
