package algorithms;

import java.util.Scanner;

public class StringConstruction {

	static int stringConstruction(String s) {
		char[] letters = new char[s.length()];
		letters = s.toCharArray();
		int[] alphabets = new int[26];
		int count = 0;
		
		for(int i=0;i<s.length();i++) {
			int position = (int) letters[i] - 97;
			if(alphabets[position] == 0) {
				alphabets[position] = 1;
				count += 1;
			}
		}
		return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = stringConstruction(s);
            System.out.println(result);
        }
        in.close();
    }
}
