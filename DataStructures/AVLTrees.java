package problems;

import java.util.Scanner;

class AVLTrees {
	public static AVLTrees root = null;
	public int info;
	public int heightOfNode;
	public AVLTrees leftNode;
	public AVLTrees rightNode;

	AVLTrees(int value, AVLTrees leftChild, AVLTrees rightChild) {
		this.info = value;
		this.heightOfNode = -1;
		this.leftNode = leftChild;
		this.rightNode = rightChild;
	}

	public void AVLTreesInsertInTree(AVLTrees start ) {
		AVLTrees currLink = start;
		AVLTrees prevLink = null;
		AVLTrees parentOfPrevLink = null;

		while (currLink != null) {
			if (this.info <= currLink.info) {
				parentOfPrevLink = prevLink;
				prevLink = currLink;
				currLink = currLink.leftNode;
			} else {
				parentOfPrevLink = prevLink;
				prevLink = currLink;
				currLink = currLink.rightNode;
			}
		}
		if (this.info <= prevLink.info) {
			prevLink.leftNode = this;
		} else {
			prevLink.rightNode = this;
		}
		calibrateBalancingFactor(this, prevLink, parentOfPrevLink);
		return;
	}

	public void AVLInorderTraversal(AVLTrees start) {
		if (start != null) {
			AVLInorderTraversal(start.leftNode);
			System.out.println(start.info);
			AVLInorderTraversal(start.rightNode);
		}
	}

	public int height(AVLTrees head) {
		if (head == null)
			return -1;;
		int val1 = height(head.leftNode);
		int val2 = height(head.rightNode);
		return 1 + ((val1 > val2) ? val1 : val2);
	}
	
	public int balancingFactor(AVLTrees head) {
		if (head == null)
			return -1;;
		int val1 = balancingFactor(head.leftNode);
		int val2 = balancingFactor(head.rightNode);
		return (val1-val2);
	}

	public void calibrateBalancingFactor(AVLTrees currLink, AVLTrees parentOfCurr, AVLTrees parentOfParent) {
		if (parentOfCurr != null) {
			int heightOfParent = balancingFactor(parentOfCurr);;
			if (parentOfParent != null) {
				int heightOfGrandParent = balancingFactor(parentOfParent);
				if (heightOfGrandParent == 1 | heightOfGrandParent == -1 | heightOfGrandParent == 0) {
					return;
				} else {
					AVLTrees grandParent = findGrandParent(root, parentOfParent);
					if (heightOfGrandParent > 0) {
						if (heightOfParent > 0) {
							rightRotation(currLink, parentOfCurr, parentOfParent);
							if (grandParent != null) {
								if (grandParent.info > parentOfParent.info)
									grandParent.leftNode = parentOfCurr;
								else
									grandParent.rightNode = parentOfCurr;
							}
						} else {
							leftSingleRotation(currLink, parentOfCurr, parentOfParent);
							rightRotation(parentOfCurr, currLink, parentOfParent);
							if (grandParent != null) {
								if (grandParent.info > parentOfParent.info)
									grandParent.leftNode = currLink;
								else
									grandParent.rightNode = currLink;
							}
						}
					} else {
						if (heightOfParent > 0) {
							rightSingleRotation(currLink, parentOfCurr, parentOfParent);
							leftRotation(parentOfParent, currLink, parentOfParent);
							if (grandParent != null) {
								if (grandParent.info > parentOfParent.info)
									grandParent.leftNode = currLink;
								else
									grandParent.rightNode = currLink;
							}
						} else {
							leftRotation(currLink, parentOfCurr, parentOfParent);
							if (grandParent != null) {
								if (grandParent.info > parentOfParent.info)
									grandParent.leftNode = parentOfCurr;
								else
									grandParent.rightNode = parentOfCurr;
							}
						}
					}
				}
			}
		}
	}

	public void rightRotation(AVLTrees leaf, AVLTrees Parent, AVLTrees grandParent) {
		Parent.rightNode = grandParent;
		grandParent.rightNode = null;
		grandParent.leftNode = null;
	}

	public void leftRotation(AVLTrees leaf, AVLTrees Parent, AVLTrees grandParent) {
		Parent.leftNode = grandParent;
		grandParent.leftNode = null;
		grandParent.rightNode = null;
	}

	public void leftSingleRotation(AVLTrees leaf, AVLTrees Parent, AVLTrees grandParent) {
		leaf.leftNode = Parent;
		grandParent.leftNode = leaf;
		Parent.leftNode = null;
		Parent.rightNode = null;
	}

	public void rightSingleRotation(AVLTrees leaf, AVLTrees Parent, AVLTrees grandParent) {
		leaf.rightNode = Parent;
		grandParent.rightNode = leaf;
		Parent.leftNode = null;
		Parent.rightNode = null;
	}

	public AVLTrees findGrandParent(AVLTrees rootNode, AVLTrees currNode) {
		AVLTrees currLink = rootNode;
		AVLTrees prevLink = null;
		if (currNode.equals(rootNode)) return rootNode;
		while (currLink.info != currNode.info) {
			prevLink = currLink;
			if (currNode.info > currLink.info) {
				prevLink = currLink;
				currLink = currLink.rightNode;
			} else {
				prevLink = currLink;
				currLink = currLink.leftNode;
			}
		}
		return prevLink;
	}

	public static void main(String[] args) {
		boolean isFirstNode = false;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the no.of nodes in the tree : " );
		int noOfElements = in.nextInt();

		for (int i = 0; i < noOfElements; i++) {
			System.out.print("Enter the element to be inserted : ");
			int valueToBeInserted = in.nextInt();
			if (!isFirstNode) {
				root = new AVLTrees(valueToBeInserted, null, null);
				isFirstNode = true;
				continue;
			}
			AVLTrees newNode = new AVLTrees(valueToBeInserted, null, null);
			newNode.AVLTreesInsertInTree(root);
		}

		root.AVLInorderTraversal(root);

		in.close();
	}
}
