package algorithms;

import java.util.Scanner;

public class Pangram {
	
	public static char[] alphabets = new char[26];

	public static void main(String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int length = s.length();
		
		char[] letters = new char[length];
		letters = s.toCharArray();
		int top = -1;
		
		for(int i=0;i<length;i++) {
			if((letters[i] >= 65 && letters[i] <= 90) | (letters[i] >=97 && letters[i] <= 122)) {
				if(top == -1) {
					alphabets[++top] = letters[i];
					continue;
				}
				if(!isAlphabetsExists(top, letters[i])) {
					alphabets[++top] = letters[i];
				}
			}
		}
		
		String output = "not pangram";
		if(top == 25) {
			output = "pangram";
		}
		
		System.out.println(output);
		
		in.close();
    }
	
	public static boolean isAlphabetsExists(int n, char alphabet) {
		boolean isPresent = false;
		if(alphabet >= 65 && alphabet <= 90) {
			//upper case			
			for(int i=0;i<=n;i++) {
				if(alphabets[i] == alphabet) {
					isPresent = true;
					break;
				}
			}
			int alpha = (int) alphabet;
			alpha = alpha + 32;
			alphabet = (char) alpha;
			for(int i=0;i<=n;i++) {
				if(alphabets[i] == alphabet) {
					isPresent = true;
					break;
				}
			}
		} else if (alphabet >=97 && alphabet <= 122) {
			for(int i=0;i<=n;i++) {
				if(alphabets[i] == alphabet) {
					isPresent = true;
					break;
				}
			}
			int alpha = (int) alphabet;
			alpha = alpha - 32;
			alphabet = (char) alpha;
			for(int i=0;i<=n;i++) {
				if(alphabets[i] == alphabet) {
					isPresent = true;
					break;
				}
			}
		}
		
		return isPresent;
	}
}
