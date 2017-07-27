package algorithms;

import java.util.Scanner;

public class CamelCase {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        
        int length = s.length();
        char[] chars = new char[length];
        chars = s.toCharArray();
        int count = 1;
        
        for(int i=0;i<length;i++) {
        	if(chars[i] >= 65 && chars[i] <= 96) {
        		count += 1;
        	}
        }
        System.out.println(count);
        in.close();
    }
	
}
