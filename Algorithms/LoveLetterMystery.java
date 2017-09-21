package algorithms;

import java.util.Scanner;

public class LoveLetterMystery {

	static int theLoveLetterMystery(String s){
        int length = s.length();
        char[] letters = new char[length];
        letters = s.toCharArray();
        char[] reverse = new char[length];
        int top = -1;
        int count = 0;
        for(int j=length-1;j>=0;j--) {
        	reverse[++top] = letters[j];
        }
        for(int i=0;i<length;i++) {
        	if(reverse[i] == letters[i]) {
        		continue;
        	} else {
        		int diff = (int) letters[i] - (int) reverse[i];
        		if(diff < 0) {
        			continue;
        		} else {
        			count = count + diff;
        		}
        	}
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = theLoveLetterMystery(s);
            System.out.println(result);
        }
        in.close();
    }
}
