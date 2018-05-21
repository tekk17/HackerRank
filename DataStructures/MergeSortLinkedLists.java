package dataStructures;

class LinkedListNode {
	int info;
	LinkedListNode next;

	LinkedListNode(int data) {
		info = data;
		next = null;
	}

	public void insertNewNode(LinkedListNode start, int data) {
		if(start == null) {
			return;
		}

		LinkedListNode currentNode = start;
		LinkedListNode previousNode = null;
		while(currentNode != null) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}

		LinkedListNode newNode = new LinkedListNode(data);
		newNode.next = null;
		previousNode.next = newNode;

	}

	public LinkedListNode getMiddleNode(LinkedListNode start) {
		int count = 0;

		LinkedListNode currentNode = start;
		while(currentNode != null) {
			count += 1;
			currentNode = currentNode.next;
		}

		int middle = count/2;

		currentNode = start;
		LinkedListNode previousNode = null;
		for(int i=0;i<middle;i++) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}

		return previousNode;
	}

	public int getLinkedListCount(LinkedListNode start) {
		int count = 0;

		LinkedListNode currentNode = start;
		while(currentNode != null) {
			count += 1;
			currentNode = currentNode.next;
		}

		return count;
	}
}

public class MergeSortLinkedLists {

	public LinkedListNode LinkedListMergeSort(LinkedListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		LinkedListNode midNode = head.getMiddleNode(head);
		LinkedListNode nextToMidNode = midNode.next;
		midNode.next = null;

		LinkedListNode leftNode = LinkedListMergeSort(head);
		LinkedListNode rightNode = LinkedListMergeSort(nextToMidNode);

		LinkedListNode sortedNode = LinkedListMerge(leftNode,rightNode);

		return  sortedNode;
	}

	public LinkedListNode LinkedListMerge(LinkedListNode left, LinkedListNode right) {
		if(left == null) return right;
		if(right == null) return left;

		LinkedListNode result = null;

		if(left.info > right.info) {
			result = right;
			result.next = LinkedListMerge(result.next,left);
		} else {
			result = left;
			result.next = LinkedListMerge(result.next,right);
		}

		return result;
	}

	public void printLinkedList(LinkedListNode start) {
		if(start == null) return;

		while(start != null) {
			System.out.print(start.info + " ");
			start = start.next;
		}
		System.out.println();
	}

	public LinkedListNode performLinkedListIntersection(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode intersectionNode = null;

		if(head1 == null && head2 == null) {
			return null;
		}

		if(head1 == null) return head2;

		if(head2 == null) return head1;

		LinkedListNode currentNode1 = head1;
		LinkedListNode currentNode2 = head2;
		LinkedListNode result = null;

		int count1 = head1.getLinkedListCount(head1);
		int count2 = head2.getLinkedListCount(head2);

		while(currentNode1 != null && currentNode2 != null) {
			if(currentNode1.info < currentNode2.info) {
				currentNode1 = currentNode1.next;
			} else if (currentNode1.info > currentNode2.info){
				currentNode2 = currentNode2.next;
			} else if(currentNode1.info == currentNode2.info) {
				LinkedListNode newNode = new LinkedListNode(currentNode1.info);
				if(result == null) {
					result = newNode;
				} else {
					LinkedListNode currentNodePointer = result;
					while(currentNodePointer.next != null) {
						currentNodePointer = currentNodePointer.next;
					}
					currentNodePointer.next = newNode;
				}
				currentNode1 = currentNode1.next;
				currentNode2 = currentNode2.next;
			}
		}

		/*while(currentNode1 != null) {
			result.next = currentNode1;
			currentNode1 = currentNode1.next;
		}

		while(currentNode2 != null) {
			result.next = currentNode2;
			currentNode2 = currentNode2.next;
		}*/

		return result;

	}

	public static void main(String[] args) {
		LinkedListNode start = new LinkedListNode(15);
		start.insertNewNode(start,10);
		start.insertNewNode(start,5);
		start.insertNewNode(start,20);
		start.insertNewNode(start,3);
		start.insertNewNode(start,2);

		LinkedListNode start2 = new LinkedListNode(1);
		start2.insertNewNode(start2,5);
		start2.insertNewNode(start2, 17);
		start2.insertNewNode(start2, 7);
		start2.insertNewNode(start2, 2);

		MergeSortLinkedLists mergeSortLinkedLists = new MergeSortLinkedLists();

		//System.out.println("Linked List before sort: ");
		//mergeSortLinkedLists.printLinkedList(start);

		System.out.println("Linked List after sort: ");
		LinkedListNode sortedNode = mergeSortLinkedLists.LinkedListMergeSort(start);
		LinkedListNode sortedNode2 = mergeSortLinkedLists.LinkedListMergeSort(start2);
		mergeSortLinkedLists.printLinkedList(sortedNode);
		mergeSortLinkedLists.printLinkedList(sortedNode2);

		LinkedListNode unionNode = mergeSortLinkedLists.performLinkedListIntersection(sortedNode,sortedNode2);
		mergeSortLinkedLists.printLinkedList(unionNode);
	}

}
