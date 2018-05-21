package algorithms;

public class PalindromesInString {

	public static void findAllPalindromesInString(String inputString) {
		int i, j, k;   // iterators
		int rp; // length of 'palindrome radius'
		int N = inputString.length();
		int[][] R = new int[2][N+1]; // table for storing results (2 rows for odd- and even-length palindromes

		// print s first
		System.out.println("Original String : " + inputString);

		// ...then search for palindromes
		inputString = "@" + inputString + "#"; // insert 'guards' to iterate easily over s
		char[] stringArray = new char[N+2];
		stringArray = inputString.toCharArray();

		for(j = 0; j <= 1; j++)
		{
			R[j][0] = rp = 0; i = 1;
			while(i <= N)
			{
				while(stringArray[i - rp - 1] == stringArray[i + j + rp]) rp++;
				R[j][i] = rp;
				k = 1;
				while((R[j][i - k] != rp - k) && (k < rp))
				{
					R[j][i + k] = Math.min(R[j][i - k],rp - k);
					k++;
				}
				rp = Math.max(rp - k,0);
				i += k;
			}
		}

		inputString = inputString.substring(1, N+1);

		// print the results
		for(i = 1; i <= N; i++)
		{
			for(j = 0; j <= 1; j++)
				for(rp = R[j][i]; rp > 0; rp--)
				{
					for(k = 1; k < i - rp; k++) System.out.print(" ");
					System.out.println(inputString.substring(i - rp - 1,2 * rp + j));
				}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String input = "abcacbbbca";
		findAllPalindromesInString(input);
	}
}
