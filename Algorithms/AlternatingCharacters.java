package algorithms;

import java.util.Scanner;

public class AlternatingCharacters {

	public static int alternatingCharacters(String s){
		int length = s.length();
		char[] letters = new char[length];
		letters = s.toCharArray();
		int count = 0;
		char prev = letters[0];
		
		for(int i=1;i<length;i++) {
			if(letters[i] == prev) {
				count += 1;
			} else {
				prev = letters[i];
			}
		}
		return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = alternatingCharacters(s);
            System.out.println(result);
        }
        in.close();
    }
}
