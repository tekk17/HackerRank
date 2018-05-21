package algorithms;

public class SmallestSubStringWithPattern {

	public static int MAXCHARS = 256;
	public static String findSmallestSubStringWithPattern(String input, String pattern) {
		int[] inputCount = new int[MAXCHARS];
		int[] patternCount = new int[MAXCHARS];
		int inputLength = input.length();
		int patternLength = pattern.length();

		for(int i=0;i<patternLength;i++) {
			patternCount[pattern.charAt(i)]++;
		}

		int startIndex = 0;
		int start = -1;
		int minLength = Integer.MAX_VALUE;
		int subStringLength = 0;
		for(int j=0;j<inputLength;j++) {
			inputCount[input.charAt(j)]++;

			if(patternCount[input.charAt(j)] != 0 && inputCount[input.charAt(j)] <= patternCount[input.charAt(j)]) {
				subStringLength++;
			}

			if(subStringLength == patternLength) {
				while(patternCount[input.charAt(startIndex)] == 0 || (patternCount[input.charAt(startIndex)] < inputCount[input.charAt(startIndex)])) {
					if(patternCount[input.charAt(startIndex)] < inputCount[input.charAt(startIndex)]) {
						inputCount[input.charAt(startIndex)]--;
					}
					startIndex++;
				}

				int windowLength = j-startIndex+1;
				if(minLength > windowLength) {
					minLength = windowLength;
					start = startIndex;
				}
			}
		}

		if(start == -1) {
			return null;
		}

		return input.substring(startIndex,startIndex+minLength);
	}

	public static void main(String[] args) {
		String input = "abcdcccdde";
		String pattern = "xyf";

		System.out.println(findSmallestSubStringWithPattern(input,pattern));
	}
}
