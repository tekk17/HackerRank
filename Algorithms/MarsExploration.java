package algorithms;

import java.util.Scanner;

public class MarsExploration {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int length = S.length();
        
        char[] sos = new char[length];
        sos = S.toCharArray();
        int count = 0;
        
        for(int i=0;i<length;i++) {
        	if(i % 3 == 0 | i%3 == 2) {
        		if(sos[i] != 'S') {
        			count += 1;
        		} else {
        			continue;
        		}
        	} else if(i%3 == 1) {
        		if(sos[i] != 'O') {
        			count += 1;
        		} else {
        			continue;
        		}
        	}
        }
        System.out.println(count);
        in.close();
    }
	
}
