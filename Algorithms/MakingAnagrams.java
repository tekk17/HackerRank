package algorithms;

import java.util.Scanner;

public class MakingAnagrams {

	public static int makingAnagrams(String s1, String s2){
		char[] letters1 = new char[s1.length()];
		char[] letters2 = new char[s2.length()];
		letters1 = s1.toCharArray();
		letters2 = s2.toCharArray();
		int count = 0;
		int val1 = s1.length();
		int val2 = s2.length();
		
		for(int i=0;i<s1.length();i++) {
			boolean matchFound = false;
			for(int j=0;j<s2.length();j++) {
				if(letters1[i] == letters2[j]) {
					if(j == 0) {
						String s3 = s2.substring(1, s2.length());
						s2 = s3;
						letters2 = s2.toCharArray();
						matchFound = true;
						break;
					} else {
						String s3 = s2.substring(0,j);
						s3 = s3 + s2.substring(j+1,s2.length());
						s2 = s3;
						letters2 = s2.toCharArray();
						matchFound = true;
						break;
					}
				}
			}
			if(matchFound) count+= 2;
		}
		
		int output = (val1 + val2) - count;
		return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
        in.close();
    }
}
