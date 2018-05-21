package algorithms;

import java.util.Scanner;

public class CountPairsWithGivenSum {
	int[][] table;

	CountPairsWithGivenSum(int size) {
		table = new int[size][2];
	}

	public void initializeTable(int value) {
		if(table[value][0] == 0) {
			table[value][0] = 1;
			table[value][1] += 1;
		} else {
			table[value][1] += 1;
		}
	}

	public void findPairs(int sum) {
		int[][]pairs = new int[table.length][2];
		int top = -1;
		int totalPairs = 0;

		for(int i=0;i<table.length;i++) {
			if(table[i][0] != 0) {
				if(table[i][1] > 1) {
					if(table[i][0] + table[i][0] == sum) {
						int frequency = table[i][1]-1;
						int samePairs = 1;
						while(frequency>=1) {
							samePairs *= frequency;
							pairs[++top][0] = table[i][0];
							pairs[top][1] = table[i][0];
							frequency -= 1;
						}
						if(totalPairs == 0) {
							totalPairs = samePairs;
						} else {
							totalPairs += samePairs;
						}
					}
				}
				for(int j=i+1;j<table.length;j++) {
					if(sum == table[i][0] + table[j][0]) {
						totalPairs = totalPairs + table[i][1] + table[j][1];
						if(table[i][1] == 1 && table[j][1] == 1) {
							pairs[++top][0] = table[i][0];
							pairs[++top][1] = table[j][0];
						} else if(table [i][1] == table[j][1]) {
							for(int k=1;k<=table[i][1];k++) {
								pairs[++top][0] = table[i][0];
								pairs[top][1] = table[j][0];
							}
						} else {
							int limit = 0;
							if(table[i][1] > table[j][1]) {
								limit = table[j][1];
							} else {
								limit = table[i][1];
							}
							for(int k=1;k<=limit;k++) {
								pairs[++top][0] = table[i][0];
								pairs[top][1] = table[j][0];
							}
						}
					}
				}
			}
		}

		for(int m=0;m<=top;m++) {
			System.out.println(pairs[m][0] +" ," + pairs[m][1]);
		}
		System.out.println(totalPairs);
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int noOfElements = in.nextInt();
		int range = in.nextInt();

		CountPairsWithGivenSum countPairsWithGivenSum = new CountPairsWithGivenSum(range);
		for(int i=0;i<noOfElements;i++) {
			countPairsWithGivenSum.initializeTable(in.nextInt());
		}
		int sum = in.nextInt();
		countPairsWithGivenSum.findPairs(sum);
	}
}
