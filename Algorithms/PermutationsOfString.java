package algorithms;

public class PermutationsOfString {
	public void computePermutation(String prefix, String subString) {
		int n = subString.length();
		if(n == 0) System.out.println(prefix);
		else {
			for(int i=0;i<n;i++) {
				computePermutation(prefix+subString.charAt(i), subString.substring(0,i)+subString.substring(i+1,n));
			}
		}
	}

	public void permute(String inputString) {
		int[] chars = new int[26];
		char[] letters = inputString.toCharArray();
		for(int i=0;i<letters.length;i++) {
			int index = letters[i] - 65;
			chars[index] += 1;
		}
		char[] inputLetters = new char[inputString.length()];
		int k=-1;
		for(int j=0;j<26;j++) {
			if(chars[j] != 0) {
				for(int count =1;count <= chars[j];count++) {
					inputLetters[++k] = (char) (65+j);
				}
			}
		}

		String toProvide = String.valueOf(inputLetters);
		computePermutation("",toProvide);

	}

	public static void main(String[] args) {
		PermutationsOfString permutations = new PermutationsOfString();
		//permutations.permute("ABSG");
		permutations.computePermutation("","ABSG");
	}
}
