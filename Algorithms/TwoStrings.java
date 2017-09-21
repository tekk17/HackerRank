package algorithms;

import java.util.Scanner;

public class TwoStrings {

	static String twoStrings(String s1, String s2){
		char[] letters1 = new char[s1.length()];
		letters1 = s1.toCharArray();
		char[] letters2 = new char[s2.length()];
		letters2 = s2.toCharArray();
		String Output = "NO";
		
		int[] alphabets1 = new int[26];
		int[] alphabets2 = new int[26];
		
		for(int i=0;i<s1.length();i++) {
			int element = (int) letters1[i] - 97;
			if(alphabets1[element] == 0) {
				alphabets1[element] = 1;
			}
		}
		
		for(int i=0;i<s2.length();i++) {
			int element = (int) letters2[i] - 97;
			if(alphabets2[element] == 0) {
				alphabets2[element] = 1;
			}
		}
		
		for(int i=0;i<26;i++) {
			if(alphabets1[i] != 0 | alphabets2[i] != 0) {
				if(alphabets1[i] == alphabets2[i]) {
					Output = "YES";
					break;
				}
			}
		}
		return Output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s1 = in.next();
            String s2 = in.next();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
        in.close();
    }
}
