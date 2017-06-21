package problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeftRotation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner in = new Scanner(System.in);
    	int N = in.nextInt();
    	int D = in.nextInt();
    	int numList[] = new int[N];
    	
    	for (int i=0;i<N;i++) {
    		numList[i] = in.nextInt();	
    	}
    	
    	in.close();
    	
    	for(int j=0;j<D;j++) {
    		int temp = numList[0];
    		for(int k=0;k<N-1;k++) {
    			numList[k] = numList[k+1];
    		}
    		numList[N-1] = temp;
    	}
    	
    	for(int i=0;i<N;i++) {
    		System.out.print(numList[i] + " ");
    	}
    }
}