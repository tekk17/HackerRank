package algorithms;

import java.util.Scanner;

public class GameOfThrones1 {

	public static int[] alphabets = new int[26];
	
	public static String gameOfThrones(String s){
		char[] letters = new char[s.length()];
		letters = s.toCharArray();
		for(int i=0;i<s.length();i++) {
			int position = (int) letters[i] - 97;
			if(alphabets[position] == 0) {
				alphabets[position] = 1;
			} else {
				alphabets[position] += 1;
			}
		}
		
		boolean isOddFound = false;
		String output = "YES";
		for(int i=0;i<26;i++) {
			if(alphabets[i] != 0) {
				if(alphabets[i] % 2 == 0) {
					continue;
				} else {
					if(!isOddFound) {
						isOddFound = true;
						//return "NO";
					} else {
						output = "NO";
						break;
					}
				}
			}
		}
		return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
        in.close();
    }
}
