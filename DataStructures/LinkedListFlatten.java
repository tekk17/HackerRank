package dataStructures;

public class LinkedListFlatten {
	int info;
	LinkedListFlatten down;
	LinkedListFlatten right;

	LinkedListFlatten(int data) {
		info = data;
		down = null;
		right = null;
	}

	public void insertNode(LinkedListFlatten downNode, LinkedListFlatten rightNode) {
		this.down = downNode;
		this.right = rightNode;
	}

	public LinkedListFlatten performMergeNodes(LinkedListFlatten a, LinkedListFlatten b) {
		if(a == null) return b;

		if(b == null) return a;

		LinkedListFlatten result = null;

		if(a.info < b.info) {
			result = a;
			result.down = performMergeNodes(a.down,b);
		} else {
			result = b;
			result.down = performMergeNodes(a, b.down);
		}

		return result;
	}

	public LinkedListFlatten performFlattening(LinkedListFlatten start) {
		if(start == null || start.right == null) {
			return start;
		}

		start.right = performFlattening(start.right);

		start = performMergeNodes(start, start.right);

		return start;
	}

	public void printLinkedListFlatten(LinkedListFlatten start) {
		LinkedListFlatten currPtr = start;
		while(currPtr != null) {
			System.out.print(currPtr.info + " ");
			currPtr = currPtr.down;
		}
	}

	public static void main(String[] args) {
		LinkedListFlatten head1 = new LinkedListFlatten(5);
		LinkedListFlatten head2 = new LinkedListFlatten(10);
		LinkedListFlatten head3 = new LinkedListFlatten(19);
		LinkedListFlatten head4 = new LinkedListFlatten(28);
		LinkedListFlatten child11 = new LinkedListFlatten(7);
		LinkedListFlatten child12 = new LinkedListFlatten(8);
		LinkedListFlatten child13 = new LinkedListFlatten(30);
		LinkedListFlatten child21 = new LinkedListFlatten(20);
		LinkedListFlatten child31 = new LinkedListFlatten(22);
		LinkedListFlatten child32 = new LinkedListFlatten(50);
		LinkedListFlatten child41 = new LinkedListFlatten(35);
		LinkedListFlatten child42 = new LinkedListFlatten(40);
		LinkedListFlatten child43 = new LinkedListFlatten(45);

		head1.insertNode(child11,head2);
		child11.insertNode(child12,null);
		child12.insertNode(child13,null);

		head2.insertNode(child21,head3);

		head3.insertNode(child31,head4);
		child31.insertNode(child32,null);

		head4.insertNode(child41,null);
		child41.insertNode(child42,null);
		child42.insertNode(child43,null);

		LinkedListFlatten head = null;

		head = head1.performFlattening(head1);

		head.printLinkedListFlatten(head);
	}
}
