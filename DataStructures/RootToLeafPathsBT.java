package problems;

public class RootToLeafPathsBT {

	public static void findRootToLeafPaths(Node start,int[] path,int pathlength) {
		if(start == null) return;

		path[pathlength++] = start.data;

		if(start.left == null && start.right == null) {
			printRootToLeafPath(path,pathlength);
		} else {
			findRootToLeafPaths(start.left,path,pathlength);
			findRootToLeafPaths(start.right,path,pathlength);
		}
	}

	public static void printRootToLeafPath(int[] pathArray,int pathLen) {
		for(int i=0;i<pathLen;i++) {
			System.out.print(pathArray[i] + " ");
		}
		System.out.println();
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

		int[] pathArray = new int[1000];
		findRootToLeafPaths(root,pathArray,0);
	}
}
