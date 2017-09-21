package algorithms;

import java.util.Scanner;

public class SherlockAndTheValidString {

	public static String isValid(String s){
		char[] letters = new char[s.length()];
		letters = s.toCharArray();
		int[] frequency = new int[26];
		String output = "YES";
		
		for(int i=0;i<s.length();i++) {
			int letter = (int) letters[i] - 97;
			frequency[letter] += 1;
		}
		
		int[][] mode = new int[26][2];
		int top = -1;
		for(int i=0;i<26;i++) {
			if(frequency[i] != 0) {
				boolean isFreqUpdated = false;
				for(int j=0;j<i;j++) {
					if(frequency[i] == mode[j][0]) {
						mode[j][1] += 1;
						isFreqUpdated = true;
						break;
					}
				}
				if(!isFreqUpdated) {
					mode[++top][0] = frequency[i];
					mode[top][1] = 1;
				}
			}
		}
		
		if(top >= 2) {
			return "NO";
		}
		if(top == 1) {
			int diff = mode[0][1] - mode[1][1];
			if(mode[0][1] == 1 | mode[1][1] == 1) {
				output = "YES";
			} else if(diff != -1 | diff != 1) {
				return "NO";
			} else {
				output = "YES";
			}
		}
		return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
        in.close();
    }
}
