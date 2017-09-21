package algorithms;

import java.util.Scanner;

public class FunnyStrings {

	public static String funnyString(String s){
		int length = s.length();
		char[] letters = new char[length];
		letters = s.toCharArray();
		int i=1;
		int j=length-1;
		String output = new String();
		while(i<length && j>0) {
			int num1 = (int) letters[i];
			int num2 = (int) letters[i-1];
			int diff1 = num2-num1;
			if(diff1 < 0) {
				diff1 = diff1 * (-1);
			}
			int num3 = (int) letters[j-1];
			int num4 = (int) letters[j];
			int diff2 = num3-num4;
			if(diff2 < 0) {
				diff2 = diff2 * (-1);
			}
			if(diff1 == diff2) {
				i++;
				j--;
			} else {
				output = "Not Funny";
				return output;
			}
		}
		output = "Funny";
		return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
        in.close();
    }
}
