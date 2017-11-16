package problems;


import java.util.ArrayList;
import java.util.List;

public class Node {
	int data;
	Node left;
	Node right;
	
	//static ArrayList nodeData = new ArrayList();
	static List<Integer> nodeData = new ArrayList<Integer>();
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public void addLink(Node llink, Node rlink) {
		this.left = llink;
		this.right = rlink;
	}
	
	/*
	 * Print A Tree
	 */
	public void printTree(Node head, int level) {
		Node currPtr = head;
		if(currPtr != null) {
			printTree(currPtr.left,level+1);
			System.out.println(currPtr.data);
			printTree(currPtr.right,level+1);
		}
	}
	
	/*
	 * Height Of A Tree
	 */
	public static int height(Node head) {
		if (head == null) return -1;
		int val1 = height(head.left);
		int val2 = height(head.right);
		return 1+((val1>val2)?val1:val2);
	}
	
	public static int heightLeft(Node head) {
		if (head == null) return -1;
		int val1 = height(head.left);
		//int val2 = height(head.right);
		return 1+(val1);
	}
	
	public static int heightRight(Node head) {
		if (head == null) return -1;
		//int val1 = height(head.left);
		int val2 = height(head.right);
		return 1+(val2);
	}
	
	/*
	 * Top View Of A Tree
	 */
	public static void top_view(Node head) {
		traverse_tree_left(head);
		traverse_tree_right(head.right);
	}
	
	public static void traverse_tree_left(Node root) {
		if (root != null) {
			traverse_tree_left(root.left);
			System.out.print(root.data + " ");
		}
	}
	
	public static void traverse_tree_right(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			traverse_tree_right(root.right);
		}
	}
	
	/*
	 * Check If Binary Tree
	 */
	public static boolean checkBinaryOrder(Node head,int i) {
		boolean isBinary = false;
		boolean isBinary1 = false;
        boolean isBinary2 = false;
		if (head != null) {
			if (i == 0) {
	            if(head != null) {
	            	Node leftPtr = head.left;
	            	Node rightPtr = head.right;
	            	boolean isLeftNotNull = false;
	            	boolean isLeftGood = false;
	            	boolean isRightNotNull = false;
	            	boolean isRightGood = false;
	            
	            	if (leftPtr != null) {
	            		isLeftNotNull = true;
	            		if(head.data > leftPtr.data ) {
	            			isLeftGood = true;
	            		}
	            	}
	            	if(rightPtr != null) {
	            		isRightNotNull = true;
	            		if(head.data < rightPtr.data) {
	            			isRightGood = true;
	            		}
	            	}
	            	if (isLeftGood && isRightGood) {
	            		isBinary = true;
	            		return true;
	            	} else if (!isLeftNotNull && isRightGood) {
	            		isBinary = true;
	            		return true;
	            	} else if(!isRightNotNull && isLeftGood) {
	            		isBinary = true;
	            		return true;
	            	} else if (!isLeftNotNull && !isRightNotNull) {
	            		isBinary = true;
	            		return true;
	            	} else {
	            		isBinary = false;
	            		return false;
	            	}
	            }
			}
	        isBinary1 = checkBinaryOrder(head.left,i-1);
	        isBinary2 = checkBinaryOrder(head.right,i-1); 
		}
		 
		if (isBinary1 && isBinary2) {
            isBinary = true;
        } else {
            isBinary = false;
        }
	    return isBinary;
	}
	
	/*
	 * inOrder Traversal
	 */
	public static void inOrder (Node head) {
		if (head != null) {
			inOrder(head.left);
			nodeData.add(head.data);
			inOrder(head.right);
		}
	}
	
	/*
	 * Level Order Traversal
	 */
	public static void levelOrder(Node head) {
		int heightOfTree = height(head);
		for(int i=0;i<=heightOfTree;i++) {
			printLevelOrder(head,i);
		}
	}
	
	public static void printLevelOrder(Node node, int i) {
		if (node == null) return;
		if (i == 0) System.out.print(node.data + " ");
		if (i>0) {
			printLevelOrder(node.left, i-1);
			printLevelOrder(node.right, i-1);
		}
	}
	
	/*
	 * Vertical Order Traversal
	 */
	
	public static void findMinMaxHd(Node node, int min, int max, int hd) {
		if (node == null) return;
		if(hd<min) {
			min = hd;
		}else if(hd> max) {
			max = hd;
		}
		findMinMaxHd(node.left,min,max,hd-1);
		findMinMaxHd(node.right, min, max, hd+1);
	}
	
	public static void printVerticalOrder(Node node,int lineNumber,int hd) {
		if(node == null) return;
		if(lineNumber == hd) System.out.print(node.data + " ");
		printVerticalOrder(node.left, lineNumber-1, hd);
		printVerticalOrder(node.right, lineNumber+1, hd);
	}
	
	/*
	 * Boundary Traversal
	 */
	void printBoundary(Node node)
	{
		if(node != null) System.out.print(node.data + " ");
		printLeftParents(node.left);
		printLeaves(node);
		printRightParents(node.right);
	}
	
	public static void printLeftParents(Node node) {
	    if(node != null) {
	        while(node.left != null | node.right != null) {
	            System.out.print(node.data + " ");
	            if(node.left != null) {
	                node = node.left;
	                continue;
	            } else if(node.left == null && node.right != null) {
	                node = node.right;
	                continue;
	            }
	        }   
	    }
	}
	
	public static void printLeaves(Node node) {
	    if(node == null) return;
	    printLeaves(node.left);
	    if(node.left == null && node.right == null) {
	        System.out.print(node.data + " ");
	    }
	    printLeaves(node.right);
	}
	
	public static void printRightParents(Node node) {
	    if(node == null) return;
	    else if(node.left == null && node.right == null) return;
	    else if(node.right != null) {
	        printRightParents(node.right);
	    } else if(node.right == null && node.left != null) {
	        printRightParents(node.left);
	    }
        System.out.print(node.data + " ");
	}
	
	/*
	 * Main Method
	 */
	public static void main(String args[]) {
		Node parent = new Node(2);
		//Node root = parent;
		parent.addLink(null, null);
		Node leftchild = new Node(1);
		Node rightchild = new Node(4);
		Node leftleftchild = new Node(5);
		Node leftrightchild = new Node(6);
		Node leftleftleftchild = new Node(7);
		Node rightleftchild = new Node(8);
		Node rightrightchild = new Node(9);
		parent.addLink(null, rightchild);
		rightchild.addLink(leftchild, leftleftchild);
		leftchild.addLink(null, null);
		leftleftchild.addLink(null, leftrightchild);
		leftrightchild.addLink(null, leftleftleftchild);
		leftleftleftchild.addLink(null, rightleftchild);
		rightleftchild.addLink(null, rightrightchild);
		
		//parent.printTree(parent, 0);
		int heightofTree = height(parent);
		//int heightLeft = heightLeft(parent);
		//int heightRight = heightRight(parent);
		System.out.println(heightofTree);
		//top_view(parent);
		
		//boolean isBinaryLeft = false;
		//boolean isBinaryRight = false;
		boolean isBinary = false;
		
		inOrder(parent);
		int sizeOfList = nodeData.size();
		
		for (int i=0;i<sizeOfList-1;i++) {
			if (nodeData.get(i) < nodeData.get(i+1)) {
				isBinary = true;
			} else {
				isBinary = false;
				break;
			}
		}
        
        System.out.println(isBinary);
		
	}
}