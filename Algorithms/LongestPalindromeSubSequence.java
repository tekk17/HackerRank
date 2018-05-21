package algorithms;

public class LongestPalindromeSubSequence {
	/*
	Divide and Conquer method : Overlapping Problem
	 */
	public static int lpsRecursion(char[] sequence, int i, int j) {
		if(i == j) return 1;

		else if(sequence[i] == sequence[j] && i+1 == j) {
			return 2;
		}

		else if(sequence[i] == sequence[j]) {
			return lpsRecursion(sequence,i+1,j-1) + 2;
		}

		else {
			return Math.max(lpsRecursion(sequence,i+1,j), lpsRecursion(sequence,i,j-1));
		}
	}

	/*
	Dynamic Programming Method
	 */
	public static int lpsDP(char[] sequence) {
		int n = sequence.length;
		int Length[][] = new int[n][n];

		for(int i=0;i<n;i++)
			Length[i][i] = 1;

		for(int cl=2;cl<=n;cl++) {
			for(int i=0;i<n-cl+1;i++) {
				int j = i+cl-1;
				if(sequence[i] == sequence[j] && cl == 2) Length[i][j] = 2;
				else if(sequence[i] == sequence[j]) Length[i][j] = Length[i+1][j-1] + 2;
				else {
					Length[i][j] = Math.max(Length[i+1][j], Length[i][j-1]);
				}
			}
		}

		return Length[0][n-1];
	}

	public static void main(String[] args) {
		LongestPalindromeSubSequence longestPalindromeSubSequence = new LongestPalindromeSubSequence();
		String input = "GEEKSFORGEEKS";
		int n = input.length();
		int lenOP = lpsRecursion(input.toCharArray(), 0 ,n-1);
		int lenDP = lpsDP(input.toCharArray());
		System.out.println("DP : " + lenDP + " Recursion: " + lenOP);
	}
}
