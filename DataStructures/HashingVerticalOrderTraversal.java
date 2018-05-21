package dataStructures;

public class HashingVerticalOrderTraversal {
	HashTableDivisionNode[] hashTableDivisionNodes;
	int sizeOfTable;

	HashingVerticalOrderTraversal(int size) {
		sizeOfTable = size;
		hashTableDivisionNodes = new HashTableDivisionNode[((sizeOfTable+1)*2)];
	}

	public int findSizeOfHashTable(Node start) {
		int tableSize = 0;
		int sizeOfTree = Node.height(start);
		sizeOfTree += 1;
		sizeOfTree *= 2;
		return sizeOfTree;
	}

	public void insertHDInHash(int key, int element) {
		int hashKey = key + sizeOfTable;
		if(hashTableDivisionNodes[hashKey] != null) {
			HashTableDivisionNode currentNode = hashTableDivisionNodes[hashKey];
			HashTableDivisionNode previousNode = null;
			while(currentNode != null) {
				previousNode = currentNode;
				currentNode = currentNode.hashTableDivisionNode;
			}
			HashTableDivisionNode newNode = new HashTableDivisionNode(element);
			previousNode.hashTableDivisionNode = newNode;
			return;
		} else {
			HashTableDivisionNode newNode = new HashTableDivisionNode(element);
			hashTableDivisionNodes[hashKey] = newNode;
			return;
		}
	}

	public void getVerticalOrder(Node start, int horizontalDistance) {
		if(start == null) {
			return;
		}

		insertHDInHash(horizontalDistance, start.data);
		getVerticalOrder(start.left,horizontalDistance-1);
		getVerticalOrder(start.right,horizontalDistance+1);
	}

	public void printVerticalOrder() {
		for(int i=0;i<((sizeOfTable+1)*2);i++) {
			if (hashTableDivisionNodes[i] != null) {
				HashTableDivisionNode currentNode = hashTableDivisionNodes[i];
				while(currentNode != null) {
					System.out.print(currentNode.info + " ");
					currentNode = currentNode.hashTableDivisionNode;
				}
				System.out.println();
			}
		}
	}

	public static int heightOfTree(Node start) {
		if(start == null) return -1;
		int leftHeight = heightOfTree(start.left);
		int rightHeight = heightOfTree(start.right);

		return 1+((leftHeight>rightHeight)?leftHeight:rightHeight);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node leftChild = new Node(2);
		Node rightChild = new Node(3);
		Node leftLeftChild = new Node(4);
		Node leftRightChild = new Node(5);
		Node rightLeftChild = new Node(6);
		Node rightRightChild = new Node(7);
		Node rightRightLeftChild = new Node(8);
		Node rightRightRightChild = new Node(9);

		root.addLink(leftChild,rightChild);
		leftChild.addLink(leftLeftChild,leftRightChild);
		rightChild.addLink(rightLeftChild,rightRightChild);
		rightRightChild.addLink(rightRightLeftChild,rightRightRightChild);

		int heightOfTree = heightOfTree(root);
		HashingVerticalOrderTraversal hashingVerticalOrderTraversal = new HashingVerticalOrderTraversal(heightOfTree);
		hashingVerticalOrderTraversal.getVerticalOrder(root,0);
		hashingVerticalOrderTraversal.printVerticalOrder();

	}
}
