package algorithms;

public class LongestCommonPrefix {

	public static String findPrefix(String s1, String s2) {
		String result = "";
		int length1 = s1.length();
		int length2 = s2.length();

		for(int i=0,j=0;i<length1 && j<length2;i++,j++) {
			if(s1.charAt(i) == s2.charAt(j))
				result = result + String.valueOf(s1.charAt(i));
			else
				break;
		}

		return result;
	}

	public static String findLongestCommonPrefix(String[] input, int length) {
		String prefix = input[0];
		for(int i=1;i<length;i++) {
			prefix = findPrefix(prefix,input[i]);
		}
		return prefix;
	}

	public static void main(String[] args) {
		String[] input = {"geeksforgeeks", "geeks",
				"geek", "geezer"};

		int length = input.length;
		String result = findLongestCommonPrefix(input,length);
		System.out.println(result);
	}
}
