package problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EqualStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        
        int sumH1 = 0;
        int sumH2 = 0;
        int sumH3 = 0;
        
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            sumH1 += h1[h1_i];
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            sumH2 += h2[h2_i];
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            sumH3 += h3[h3_i];
        }
        
        int topOfH1 = -1;
        int topOfH2 = -1;
        int topOfH3 = -1;
        
        while (!(sumH1 == sumH2 && sumH2 == sumH3)) {
        	if (sumH1 > sumH2) {
        		if (sumH1 > sumH3) {
        			sumH1 = sumH1 - h1[++topOfH1];
        		} else {
        			sumH3 = sumH3 - h3[++topOfH3];
        		}
        	} else if (sumH2 > sumH3) {
        		sumH2 = sumH2 - h2[++topOfH2]; 
        	} else {
        		sumH3 = sumH3 - h3[++topOfH3];
        	}
        }
        
        System.out.println(sumH1);
    }
}
