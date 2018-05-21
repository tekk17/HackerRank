package dataStructures;

import java.util.Scanner;

public class DirectAddressHashing {
	int[] universe;

	DirectAddressHashing(int size) {
		universe = new int[size];
		for(int i=0;i<size;i++) {
			universe[i] = -1;
		}
	}

	public void directAddressInsert(int element) {
		if(universe[element] == -1) {
			universe[element] = 1;
		}
	}

	public boolean directAddressSearch(int element) {
		if(universe[element] == -1) {
			System.out.println("Search Failed, Element not present");
			return false;
		} else {
			System.out.println("Search Successful.");
			return true;
		}
	}

	public boolean directAddressDelete(int element) {
		if(universe[element] == -1) {
			System.out.println("Element not present");
			return false;
		} else {
			universe[element] = -1;
			System.out.println("Element deleted : " + element);
			return true;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sizeOfKeys = in.nextInt();
		DirectAddressHashing hashing = new DirectAddressHashing(sizeOfKeys);
		hashing.directAddressInsert(8);
		hashing.directAddressInsert(6);
		hashing.directAddressSearch(2);
		hashing.directAddressSearch(8);
		hashing.directAddressDelete(6);
		hashing.directAddressSearch(6);
		in.close();
	}
}
