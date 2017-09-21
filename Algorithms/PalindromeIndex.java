package algorithms;

import java.util.Scanner;

public class PalindromeIndex {

	static int palindromeIndex(String s){
		int length = s.length();
		char[] letters = new char[length];
		letters = s.toCharArray();
		int index = -1;
		int j= length-1;
		int i=0;
		while(i<length && j >= 0) {
			if(j==index) {
				j--;
				continue;
			}
			if (letters[i] == letters[j]) {
				i++;
				j--;
			} else {
				if(letters[i+1] == letters[j]) {
					index = i;
					i++;
				} else {
					index = j;
					j--;
				}
			}
		}
		return index;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = palindromeIndex(s);
            System.out.println(result);
        }
        in.close();
    }
}
