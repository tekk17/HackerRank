package easy;

import java.util.Scanner;

public class isASquare {

	public static int calculateDistance(int x1, int y1, int x2, int y2) {
		int distance1 = 2 ^ (x2-x1);
		int distance2 = 2 ^ (y2-y1);
		int distance = distance1 + distance2;

		return distance;
	}

	public static boolean isASquare(int[][] points) {

		int distance2 = calculateDistance(points[0][0], points[0][1], points[1][0], points[1][1]);
		int distance3 = calculateDistance(points[0][0], points[0][1], points[2][0], points[2][1]);
		int distance4 = calculateDistance(points[0][0], points[0][1], points[3][0], points[3][1]);

		if(distance2 == distance3 && distance2 == 2*distance4) {
			int distance = calculateDistance(points[1][0], points[1][1], points[3][0], points[3][1]);
			if(distance == distance2 && calculateDistance(points[2][0], points[2][1], points[3][0], points[3][1]) == distance3) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int noOfTests = in.nextInt();
		for(int i=0;i<noOfTests;i++) {
			for(int j=0;j<8;j++) {
				int coordinates[][] = new int[4][2];
				for(int l=0;l<4;l++) {
					for(int k=0;k<2;k++) {
						coordinates[l][k] = in.nextInt();
					}
				}
				boolean isItASquare = isASquare(coordinates);
			}
		}

	}
}
