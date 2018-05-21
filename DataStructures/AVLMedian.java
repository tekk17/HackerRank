package dataStructures;

import java.math.BigDecimal;
import java.util.Scanner;

class AVLMedian {
	public static AVLMedian root = null;
	public int info;
	public int heightOfNode;
	public AVLMedian leftNode;
	public AVLMedian rightNode;
	
	public static class Counter {
		private int value;
		public Counter(int initialValue) { value = initialValue; }
		public boolean decrement() { value--; return value == 0; }
		public boolean expired() { return value <= 0; }
	}

	public static AVLMedian AVLMedianInsertInTree(AVLMedian start, int info ) {
		if (start == null) {
			AVLMedian newNode = new AVLMedian();
			newNode.info = info;
			newNode.heightOfNode = 0;
			newNode.leftNode = null;
			newNode.rightNode = null;
			return newNode;
		}
		
		if(info <= start.info) {
			start.leftNode = AVLMedianInsertInTree(start.leftNode, info);
		} else if (info > start.info) {
			start.rightNode = AVLMedianInsertInTree(start.rightNode, info);
		} else {
			return start;
		}
		
		start.heightOfNode = height(start);
		
		int balancingFactor = balancingFactor(start);
		
		if (balancingFactor > 1 && info < start.leftNode.info) {
			return rightRotation(start);
		} else if (balancingFactor > 1 && info > start.leftNode.info) {
			start.leftNode = leftRotation(start.leftNode);
			return rightRotation(start);
		} else if (balancingFactor < -1 && info > start.rightNode.info) {
			return leftRotation(start);
		} else if (balancingFactor < -1 && info < start.rightNode.info) {
			start.rightNode = rightRotation(start.rightNode);
			return leftRotation(start);
		}
			
		return start;
	}
	
	public static AVLMedian AVLMedianRemoveFromTree(AVLMedian start, int info ) {
		AVLMedian currPtr = new AVLMedian();
		AVLMedian parent = new AVLMedian();
		AVLMedian successor = new AVLMedian();
		AVLMedian q = new AVLMedian();
		
		if(start == null) {
			return start;
		}
		
		parent = null;
		currPtr = null;
		
		while(currPtr != null) {
			if(info == currPtr.info) break;
			parent = currPtr;
			currPtr = (info<=currPtr.info)?currPtr.leftNode:currPtr.rightNode;
		}
		
		if(currPtr == null) {
			//Item not found
			return start;
		}
		
		if(currPtr.leftNode == null) {
			q = currPtr.rightNode;//for leftnode = null
		} else if(currPtr.rightNode == null) {
			q = currPtr.leftNode;//for rightnode = null
		} else {
			successor = currPtr.rightNode;//obtain inorder successor
			while(successor.leftNode != null) {
				successor = successor.leftNode;
			}
			successor.leftNode = currPtr.leftNode;//attach leaf node to be deleted to left successor of node to be deleted
			q = currPtr.rightNode;//right subtree is obtained
		}
		
		if(parent == null) return q;
		
		if(currPtr == parent.leftNode) {
			parent.leftNode = q;
		} else {
			parent.rightNode = q;
		}
		
		return start;
	}
	
	/*public static AVLMedian balancingPostDeletion(AVLMedian start) {
		start.heightOfNode = height(start);
		int balancingFactor = balancingFactor(start);
		
		if(balancingFactor > 1 && info<start.leftNode.info) {
			return rightRotation(start);
		} else if(balancingFactor > 1 && info > start.leftNode.info) {
			start.leftNode = leftRotation(start.leftNode);
			return rightRotation(start);
		}  else if (balancingFactor < -1 && info > start.rightNode.info) {
			return leftRotation(start);
		} else if (balancingFactor < -1 && info < start.rightNode.info) {
			start.rightNode = rightRotation(start.rightNode);
			return leftRotation(start);
		}
			
		return start;
	}*/

	public static int height(AVLMedian head) {
		if (head == null)
			return -1;;
		int val1 = height(head.leftNode);
		int val2 = height(head.rightNode);
		return 1 + ((val1 > val2) ? val1 : val2);
	}
	
	public static int balancingFactor(AVLMedian head) {
		if (head == null)
			return 0;
		int val1 = height(head.leftNode);
		int val2 = height(head.rightNode);
		return (val1-val2);
	}

	public static AVLMedian rightRotation(AVLMedian node) {
		AVLMedian q = node.leftNode;
		AVLMedian hold = q.rightNode;
		q.rightNode = node;
		node.leftNode = hold;
		
		q.heightOfNode = height(q);	
		node.heightOfNode = height(node);
		
		return q;
	}

	public static AVLMedian leftRotation(AVLMedian node) {
		AVLMedian q = node.rightNode;
		AVLMedian hold = q.leftNode;
		q.leftNode = node;
		node.rightNode = hold;
		
		q.heightOfNode = height(q);
		node.heightOfNode = height(node);
		
		return q;
	}
	
	public static void inOrderTraversal(AVLMedian start) {
		if (start != null) {
			inOrderTraversal(start.leftNode);
			System.out.print(start.info + " ");
			inOrderTraversal(start.rightNode);
		}
	}
	
	public static AVLMedian inOrderTraverseMedian(AVLMedian start, Counter counter){
		   if  (start != null && !counter.expired()) {
		       AVLMedian left = inOrderTraverseMedian(start.leftNode, counter);
		       if (left != null) {
		            return left;
		       } else if (counter.decrement()) {
		            return start;
		       } else {
		            return inOrderTraverseMedian(start.rightNode, counter); 
		       }
		   } else {
		       return null;
		   }
		}
	
	public static void postOrderTraversal(AVLMedian start) {
		if (start != null) {
			postOrderTraversal(start.leftNode);
			postOrderTraversal(start.rightNode);
			System.out.print(start.info + " ");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = 0;
		int N;
		N = in.nextInt();
		
		String[] s = new String[N];
		int[] elements = new int[N];
		
		for(int i=0;i<N;i++) {
			s[i] = in.next();
			elements[i] = in.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			double median = 0;
			if(s[i].equals("a")) {
				if(count == 0) {
					root = new AVLMedian();
					root.info = elements[i];
					root.heightOfNode = 0;
					root.leftNode = null;
					root.rightNode = null;
					count += 1;
					System.out.println(root.info);
					continue;
				}
				count += 1;
				root = AVLMedianInsertInTree(root, elements[i]);
				if(count == 1) {
					System.out.println(root.info);
				} else if (count == 2) {
					if(root.rightNode == null) {
						median = ((double)(root.info))/(double)2 + ((double)(root.leftNode.info)/(double)2);
					} else {
						median = ((double)(root.info))/(double)2 + ((double)(root.rightNode.info)/(double)2);
					}
		    		if ((median == Math.floor(median)) && !Double.isInfinite(median)) {
		    			long printMedian = (long)median;
		    			System.out.println(BigDecimal.valueOf(printMedian).toPlainString());
		    		} else {
		    			System.out.println(BigDecimal.valueOf(median).toPlainString());
		    		}
				} else if(count %2 == 0) {
					int mid = count / 2;
					int mid2 = mid + 1;
					AVLMedian median1 = inOrderTraverseMedian(root, new Counter(mid));
					//System.out.println("Median1:" + median1.info);
					AVLMedian median2 = inOrderTraverseMedian(root, new Counter(mid2));
					//System.out.println("Median2:" + median2.info);
					median = ((double)(median1.info))/(double)2 + ((double)(median2.info)/(double)2);
					if ((median == Math.floor(median)) && !Double.isInfinite(median)) {
		    			long printMedian = (long)median;
		    			System.out.println(BigDecimal.valueOf(printMedian).toPlainString());
		    		} else {
		    			System.out.println(BigDecimal.valueOf(median).toPlainString());
		    		}
				} else if(count % 2 == 1) {
					int mid = count/2;
					AVLMedian median1 = inOrderTraverseMedian(root, new Counter(mid+1));
					//System.out.println("Median1:" + median1.info);
					System.out.println(median1.info);
				}
			} 
			else {
				if (count == 0) {
					System.out.println("Wrong!");
					continue;
				}
				root = AVLMedianRemoveFromTree(root, elements[i]);
				//root = balancingPostDeletion(root);
				count -= 1;
				if(count == 0) {
					System.out.println("Wrong!");
				} else if(count == 1) {
					System.out.println(root.info);
				} else if(count == 2) {
					if(root.rightNode == null) {
						median = ((double)(root.info))/(double)2 + ((double)(root.leftNode.info)/(double)2);
					} else {
						median = ((double)(root.info))/(double)2 + ((double)(root.rightNode.info)/(double)2);
					}
		    		if ((median == Math.floor(median)) && !Double.isInfinite(median)) {
		    			long printMedian = (long)median;
		    			System.out.println(BigDecimal.valueOf(printMedian).toPlainString());
		    		} else {
		    			System.out.println(BigDecimal.valueOf(median).toPlainString());
		    		}
				} else if(count%2 == 0){
					int mid = count / 2;
					int mid2 = count + 1;
					AVLMedian median1 = inOrderTraverseMedian(root, new Counter(mid));
					//System.out.println("Median1:" + median1.info);
					AVLMedian median2 = inOrderTraverseMedian(root, new Counter(mid2));
					//System.out.println("Median2:" + median2.info);
					median = ((double)(median1.info))/(double)2 + ((double)(median2.info)/(double)2);
					if ((median == Math.floor(median)) && !Double.isInfinite(median)) {
		    			long printMedian = (long)median;
		    			System.out.println(BigDecimal.valueOf(printMedian).toPlainString());
		    		} else {
		    			System.out.println(BigDecimal.valueOf(median).toPlainString());
		    			}
					} else if (count % 2 == 1) {
						int mid = count/2;
						AVLMedian median1 = inOrderTraverseMedian(root, new Counter(mid+1));
						//System.out.println("Median1:" + median1.info);
						System.out.println(median1.info);
					}
				}
			}
		in.close();
	}
}
