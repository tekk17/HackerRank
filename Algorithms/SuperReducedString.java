package algorithms;

import java.util.Scanner;

public class SuperReducedString {

	static String super_reduced_string(String s){
		int len = s.length();
		char[] chars = new char[len];
		chars = s.toCharArray();
		String result = new String();
		
		for(int i=0;i<len-1;) {
			if(chars[i] == chars[i+1]) {
				for(int j=i+2;j<len;j++) {
					chars[j-2] = chars[j];
				}
				len = len-2;
				i=0;
			} else {
				i += 1;
			}
		}
		
		if(len == 0) {
			result = "Empty String";
		} else {
			char[] outputString = new char[len];
			for(int k=0;k<len;k++) {
				outputString[k] = chars[k];
				result = result + outputString[k];
			}
		}
		
		return result;
		
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
        in.close();
    }
}
