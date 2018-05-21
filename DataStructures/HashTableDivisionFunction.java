package dataStructures;

import java.util.Scanner;

class HashTableDivisionNode {
	int info;
	HashTableDivisionNode hashTableDivisionNode;

	HashTableDivisionNode (int element) {
		info = element;
		hashTableDivisionNode = null;
	}
}
public class HashTableDivisionFunction {
	HashTableDivisionNode[] Table;
	int hashKey;
	HashTableDivisionFunction(int noOfElementsToInsert) {
		hashKey = computeSizeOfTable(noOfElementsToInsert);
		Table = new HashTableDivisionNode[hashKey];
	}

	public int computeSizeOfTable(int sizeOfKeys) {
		int countOf2 = 0;
		int quotient = 0;
		int n= sizeOfKeys;
		while(n > 1) {
			quotient = n/2;
			countOf2 += 1;
			n = quotient;
		}
		int higherCountOf2 = (int) Math.pow(2, (countOf2+1));
		int size = 0;
		for(int i=sizeOfKeys+1;i<higherCountOf2;i++) {
			int halfLimit = i/2;
			int j=2;
			boolean isPrime = true;
			while(j<=halfLimit) {
				if((i%j)==0) {
					isPrime = false;
					break;
				}
				j++;
			}
			if(isPrime) {
				size = i;
				break;
			}
		}
		return size;
	}

	public void insertElementInTable(int element) {
		HashTableDivisionNode newNode = new HashTableDivisionNode(element);
		int key = element % hashKey;
		if(Table[key] == null) {
			Table[key] = newNode;
		} else {
			HashTableDivisionNode currentNode = Table[key];
			//HashTableDivisionNode previousNode = currentNode;
			while (currentNode.hashTableDivisionNode != null) {
				//previousNode = currentNode;
				currentNode = currentNode.hashTableDivisionNode;
			}
			currentNode.hashTableDivisionNode = newNode;
		}
		return;
	}

	public boolean deleteElementInTable(int element) {
		int key = element % hashKey;
		if(Table[key] == null) {
			System.out.println("Element not present.");
			return false;
		}
		HashTableDivisionNode currentNode = Table[key];
		if(currentNode.info == element) {
			Table[key] = currentNode.hashTableDivisionNode;
			return true;
		} else {
			HashTableDivisionNode previousNode = null;
			boolean isElementFound = false;
			while (currentNode != null) {
				if(currentNode.info == element) {
					isElementFound = true;
					break;
				}
				previousNode = currentNode;
				currentNode = currentNode.hashTableDivisionNode;
			}
			if(isElementFound) {
				previousNode.hashTableDivisionNode = currentNode.hashTableDivisionNode;
				return true;
			} else {
				System.out.println("Element not present.");
				return false;
			}
		}
	}

	public boolean searchElementInTable(int element) {
		int key = element % hashKey;
		boolean isElementFound = false;
		if(Table[key] == null) {
			System.out.println("Element not present.");
			return false;
		}
		HashTableDivisionNode currentNode = Table[key];
		if(currentNode.info == element) {
			System.out.println("Element found : " + element);
			return true;
		} else {
			HashTableDivisionNode previousNode = null;
			while (currentNode != null) {
				if(currentNode.info == element) {
					isElementFound = true;
					System.out.println("Element found : " + element);
					return isElementFound;
				}
				previousNode = currentNode;
				currentNode = currentNode.hashTableDivisionNode;
			}
		}
		return isElementFound;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfElements = in.nextInt();
		HashTableDivisionFunction hashTableDivisionFunction = new HashTableDivisionFunction(noOfElements);
		hashTableDivisionFunction.insertElementInTable(12);
		hashTableDivisionFunction.insertElementInTable(15);
		hashTableDivisionFunction.insertElementInTable(37);
		hashTableDivisionFunction.insertElementInTable(38);
		hashTableDivisionFunction.searchElementInTable(12);
		hashTableDivisionFunction.searchElementInTable(10);

		in.close();
	}

}
