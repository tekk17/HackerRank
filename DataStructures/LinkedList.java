package problems;

import org.w3c.dom.Node;

public class LinkedList {
	private int info;
	protected LinkedList start;
	protected LinkedList currPtr;
	
	LinkedList(int data) {
		this.info = data;
	}
	
	public static void main(String[] args) {
		LinkedList node = new LinkedList(10);
	}
}
