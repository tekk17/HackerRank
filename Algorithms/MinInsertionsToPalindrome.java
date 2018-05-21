package algorithms;

public class MinInsertionsToPalindrome {

	public static int findMinInsertionsToPalindrome(String input, int low, int high) {
		int length = input.length();

		if(low == high) return 0;

		if(high == low+1) {
			if(input.charAt(low) == input.charAt(high)) return 0;
			else return 1;
		}

		int[][] insertionTable = new int[length][length];
		char[] inputLetters = new char[length];
		inputLetters = input.toCharArray();

		for(int gap = 1;gap<length;gap++) {
			for(int i=0,j=gap;j<length;i++,j++) {
				insertionTable[i][j] = (inputLetters[i] == inputLetters[j]?insertionTable[i+1][j-1]:Math.min(insertionTable[i][j-1],insertionTable[i+1][j])+1);
			}
		}

		return insertionTable[0][length-1];
	}

	public static void main(String[] args) {
		String inputString = "abc";
		System.out.println(findMinInsertionsToPalindrome(inputString,0,inputString.length()));
	}
}
