package algorithms;

import java.util.Scanner;

public class Anagram {

	public static int anagram(String s){
		int length = s.length();
		if(!(length % 2 == 0)) {
			return -1;
		}
		int mid = length/2;
		String s1 = s.substring(0, mid);
		String s2 = s.substring(mid,length);
		char[] letters1 = new char[s1.length()];
		letters1 = s1.toCharArray();
		char[] letters2 = new char[s2.length()];
		letters2 = s2.toCharArray();
		
		int count = 0;
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
			if(!matchFound) count += 1;
		}
		return count;
    }
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = anagram(s);
            System.out.println(result);
        }
        in.close();
    }
}
