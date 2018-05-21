package easy;

import java.util.Scanner;

public class booleanMatrix {

	public static void populateBooleanMatrix(int[][] matrix, int rows, int columns) {
		int outputMatrix[][] = new int[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				if(matrix[i][j] == 1) {
					for(int r=0;r<columns;r++) {
						outputMatrix[i][r] = 1;
					}
					for(int c=0;c<rows;c++) {
						outputMatrix[c][j] = 1;
					}
				}
			}
		}

		for(int l=0;l<rows;l++) {
			for(int m=0;m<columns;m++) {
				System.out.print(outputMatrix[l][m] + " ");
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		for(int i=0;i<tests;i++) {
			int rows = in.nextInt();
			int columns = in.nextInt();
			int[][] matrix = new int[rows][columns];
			for(int k=0;k<rows;k++) {
				for(int j=0;j<columns;j++) {
					matrix[k][j] = in.nextInt();
				}
			}
			populateBooleanMatrix(matrix,rows,columns);
			System.out.println();
		}
	}
}
