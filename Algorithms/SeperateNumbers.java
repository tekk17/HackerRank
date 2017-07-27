package algorithms;

import java.util.Scanner;

public class SeperateNumbers {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int length = s.length();
            int mid = length/2;
            boolean isBeautiful = false;
            String index = new String();
            
            for(int i=0;i<mid;i++) {
            	String temp = new String();
        		temp = s.substring(0,i+1);
        		index = temp;
            	int lenOfTemp = 0;
            	long number = Long.parseLong(temp);
            	while(lenOfTemp <length ) {
                	number += 1;
                	temp = temp+number;
                	lenOfTemp = temp.length();
            	}
            	if(temp.equals(s) && lenOfTemp == length) {
            		isBeautiful = true;
            		break;
            	}
            }
            
            if(isBeautiful) {
            	System.out.println("YES " + index);
            } else {
            	System.out.println("NO");
            }
        }
        in.close();
    }
}
