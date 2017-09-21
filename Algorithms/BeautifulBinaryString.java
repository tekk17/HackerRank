package algorithms;

import java.util.Scanner;

public class BeautifulBinaryString {

	static int minSteps(int n, String B){
		int length = B.length();
		char[] letters = new char[length];
		letters = B.toCharArray();
		int i=0;
		int count = 0;
		while(i<length) {
			if(letters[i] == '0' && letters[i+1] == '1' && letters[i+2] == '0') {
				count += 1;
				i = i+3;
			} else {
				i += 1;
			}
		}
		return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String B = in.next();
        int result = minSteps(n, B);
        System.out.println(result);
        in.close();
    }
}
