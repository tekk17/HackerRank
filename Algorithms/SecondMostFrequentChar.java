package algorithms;

import java.util.*;

public class SecondMostFrequentChar {

	public static Map<Character,Integer> charFrequency = new Hashtable<Character, Integer>();

	public static void findSecondMostFrequentChar(String input) {
		int length = input.length();

		for(int i=0;i<length;i++) {
			if(!charFrequency.containsKey(input.charAt(i))) {
				charFrequency.put(input.charAt(i),1);
			} else {
				int value = charFrequency.get(input.charAt(i));
				charFrequency.put(input.charAt(i),value+1);
			}
		}

		Iterator<Map.Entry<Character,Integer>> entryIterator = charFrequency.entrySet().iterator();

		int maxValue = 0;
		int prevMax = 0;
		char alphabet = ' ';
		char secondAlphabet = ' ';
		while(entryIterator.hasNext()) {
			Map.Entry<Character,Integer> charOccurrence = entryIterator.next();
			if(maxValue < charOccurrence.getValue()) {
				prevMax = maxValue;
				maxValue = charOccurrence.getValue();
				secondAlphabet = alphabet;
				alphabet = charOccurrence.getKey();
			}
		}

		System.out.println("character : " + secondAlphabet + " frequency : " + prevMax);

	}

	public static void main(String[] args) {
		//findSecondMostFrequentChar("aaabccdddd");
		findSecondMostFrequentChar("abcd");
	}
}
