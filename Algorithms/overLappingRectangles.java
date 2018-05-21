package easy;

import java.util.Scanner;

public class overLappingRectangles {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTests = in.nextInt();

		for(int i=0;i<noOfTests;i++) {
			int L1x = in.nextInt();
			int L1y = in.nextInt();
			int R1x = in.nextInt();
			int R1y = in.nextInt();
			int L2x = in.nextInt();
			int L2y = in.nextInt();
			int R2x = in.nextInt();
			int R2y = in.nextInt();

			if(L1x > R2x || L2x > R1x) {
				System.out.println(0);
				continue;
			}
			else if(L1y < R2y || L2y < R1y) {
				System.out.println(0);
				continue;
			}
			System.out.println(1);
		}
	}
}
