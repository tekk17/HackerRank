package algorithms;

import java.util.Scanner;

public class TwoCharacters {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        
        char[] chars = new char[len];
        chars = s.toCharArray();
        char[] alphabets = new char[len];
        int result = 0;
        
        int j = -1;
        for(int i=0;i<len;i++) {
        	if(ifNotPresent(alphabets,chars[i])) {
        		alphabets[++j] = chars[i];
        	}
        }
        
        for(int i=0;i<j;i++) {
        	for(int k=i+1;k<=j;k++) {
        		char charA = alphabets[i];
        		char charB = alphabets[k];
        		int count = stringCount(s,charA,charB);
        		if(count > result) {
        			result = count;
        		}
        	}
        }
        System.out.println(result);
        in.close();
    }
	
	public static boolean ifNotPresent(char[] letters, char letter) {
		boolean result = true;
		
		int i=0;
		while(letters[i] != '\0') {
			if(letters[i] == letter) {
				result = false;
				break;
			} else {
				i++;
			}
		}
		
		return result;
	}
	
	public static int stringCount(String sequence, char char1, char char2) {
		int count = 0;
		
		int len = sequence.length();
		char[] letters = new char[len];
		letters = sequence.toCharArray();
		char[] newString = new char[len];
		int top = -1;
		
		for(int i=0;i<len;i++) {
			if(letters[i] == char1) {
				newString[++top] = letters[i];
			} else if(letters[i] == char2) {
				newString[++top] = letters[i];
			}
		}
		
		if(top == 1) {
			if(newString[0] == newString[1]) {
				return count;
			} else {
				count += 2;
				return count;
			}
		}
		
		for(int i=0;i<=top;i++) {
			if(newString[i] == newString[i+1]) {
				count = 0;
				break;
			} else {
				count += 1;
			}
		}
		
		return count;
	}
	
}
