package algorithms;

import java.util.Scanner;

public class CaesarCipher {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        
        int length = s.length();
        char[] characters = new char[length];
        characters = s.toCharArray();
        
        for(int i=0;i<length;i++) {
        	if(characters[i] >= 65 && characters[i] <= 90) {
            	//Upper Case
        		int letter = (int)characters[i] + k;
        		if(letter >= 91) {
        			int diff = letter - 91;
        			int newLetter = diff%26;
        			characters[i] = (char) (65+newLetter);
        			continue;
        		}
        		characters[i] = (char) letter;
        	} else if(characters[i] >= 97 && characters[i] <= 122) {
        		//Lower Case
        		int letter = (int)characters[i] + k;
        		if(letter >= 123) {
        			int diff = letter - 123;
        			int newLetter = diff%26;
        			characters[i] = (char) (97+newLetter);
        			continue;
        		}
        		characters[i] = (char) letter;
        	} else {
        		continue;
        	}
        }
        
        String output = new String();
        output = String.valueOf(characters);
        
        System.out.println(output);
        
        
        in.close();
    }

}
