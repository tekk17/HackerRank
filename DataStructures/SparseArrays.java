package problems;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class SparseArrays {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		List<String> strList = new ArrayList<String>();
		List<String> compareList = new ArrayList<String>();
		
		for(int i=0;i<N;i++) {
			strList.add(in.next());
		}
		
		int Q = in.nextInt();
		for(int j=0;j<Q;j++) {
			compareList.add(in.next());
		}
		
		for(int j=0;j<Q;j++) {
			int count = 0;
			for(int i=0;i<N;i++) {
				if (compareList.get(j).equals(strList.get(i))) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
