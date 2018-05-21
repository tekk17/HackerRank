package algorithms;

import java.util.HashSet;

public class SubSequencesOfString {

	public static HashSet<String> stringSet = new HashSet<>();

	public static void generateSubSequences(String input) {
		for(int i=0;i<input.length();i++) {
			for(int j=input.length();j>i;j--) {
				String subString = input.substring(i,j);
				if(!stringSet.contains(subString)) {
					stringSet.add(subString);
				}

				for(int k=1;k<subString.length()-1;k++) {
					StringBuffer stringBuffer = new StringBuffer(subString);
					stringBuffer.deleteCharAt(k);
					if(!stringSet.contains(stringBuffer)) {
						generateSubSequences(stringBuffer.toString());
					}
				}
			}

		}
	}

	public static void main(String[] args) {
		generateSubSequences("aabc");
		System.out.println(stringSet);
	}

}
