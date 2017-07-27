package algorithms;

import java.util.Scanner;

public class WeightedUniformStringV2 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        int length = s.length();
        int[][] weights = new int[length][2];
        int topX = -1;
        
        char[] letters = new char[length];
        letters = s.toCharArray();
        
        for(int i=0;i<length;) {
        	char alphabet = letters[i];
        	int weight = (int) alphabet - 96;
        	int count = 0;
        	int j=i;
        	for(;j<length;j++) {
        		if(letters[j] == alphabet) {
        			count += 1;
        			if(j == length-1) {
                		weights[++topX][0] = weight;
                		weights[topX][1] = count;
                	}
        		} else {
        			weights[++topX][0] = weight;
        			weights[topX][1] = count;
        			break;
        		}
        	}
        	
        	i = i+count;
        	
        }
        
        for(int i=0;i<n;i++) {
        	int element = in.nextInt();
        	boolean isFound = false;
        	for(int l=0;l<=topX;l++) {
        		int remainder = element % weights[l][0];
        		if(remainder == 0) {
        			int quotient = element / weights[l][0];
        			if(quotient <= weights[l][1]) {
        				System.out.println("Yes");
        				isFound = true;
        				break;
        			}
        		}
        	}
        	if(!isFound) {
        		System.out.println("No");
        	}
        }
        
        in.close();
	}
}
