package problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DynamicArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        /*List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < 4; i++) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            // Use the list further...
        }*/
    	List<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>();
    	for (int i=0;i<N;i++) {
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		seqList.add(list);
    	}
    	int query[][] = new int[Q][3];
    	int lastAns = 0;
    	
    		for (int q=0;q<Q;q++) {
    			for (int i=0;i<3;i++) {
    				query[q][i] = in.nextInt();
    		}
    	}
    	
    	for (int q=0;q<Q;q++) {
    			if (query[q][0] == 1) {
    				int seq = (query[q][1] ^ lastAns) % N;
    				seqList.get(seq).add(query[q][2]);
    		} else {
    			//lastAns = 0;
    			int seq = (query[q][1] ^ lastAns) % N;
    			int size = seqList.get(seq).size();
    			int index = (query[q][2] % size);
    			lastAns = seqList.get(seq).get(index);
    			System.out.println(lastAns);
    		}
    	}
    }
}