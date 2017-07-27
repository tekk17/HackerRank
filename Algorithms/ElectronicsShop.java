package algorithms;

import java.util.Scanner;

public class ElectronicsShop {

	static int getMoneySpent(int[] keyboards, int[] drives, int s, int n, int m) {
		int count = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int sum = keyboards[i] + drives[j];
				if (sum <= s && sum > count) {
					count = sum;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int n = in.nextInt();
		int m = in.nextInt();
		int[] keyboards = new int[n];
		for (int keyboards_i = 0; keyboards_i < n; keyboards_i++) {
			keyboards[keyboards_i] = in.nextInt();
		}
		int[] drives = new int[m];
		for (int drives_i = 0; drives_i < m; drives_i++) {
			drives[drives_i] = in.nextInt();
		}
		// The maximum amount of money she can spend on a keyboard and USB
		// drive, or -1 if she can't purchase both items
		int moneySpent = getMoneySpent(keyboards, drives, s, n, m);
		System.out.println(moneySpent);
		in.close();
	}

}
