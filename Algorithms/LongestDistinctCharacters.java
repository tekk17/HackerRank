package algorithms;

public class LongestDistinctCharacters {

	public static int findLongestSubSequence(String sequence) {
		char[] sequenceArray = sequence.toCharArray();
		int length = sequenceArray.length;
		int[] visitedIndex = new int[256];
		int currentLength = 0;
		int maxLength = 0;

		for(int i=0;i<256;i++) {
			visitedIndex[i] = -1;
		}

		visitedIndex[sequenceArray[0]] = 0;
		for(int i=1;i<length;i++) {
			int index = visitedIndex[sequenceArray[i]];
			if(index == -1 || i-currentLength>index) {
				currentLength++;
			} else {
				if(currentLength>maxLength) maxLength=currentLength;
				currentLength = i-index;
			}
			visitedIndex[sequenceArray[i]] = i;
		}
		if(currentLength > maxLength) maxLength=currentLength;

		return maxLength;
	}

	public static void main(String[] args) {
		String inputString = "abababcdefababcdab";
		int result1 = findLongestSubSequence(inputString);
		inputString = "geeksforgeeks";
		int result2 = findLongestSubSequence(inputString);
		System.out.println(result1 + " " + result2);
	}
}
