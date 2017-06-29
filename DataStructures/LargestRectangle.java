package problems;

import java.util.Scanner;

public class LargestRectangle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int noOfElements = in.nextInt();
		
		int[] heights = new int[noOfElements];
		int largestRectangle = 0;
		
		for(int i=0;i<noOfElements;i++) {
			heights[i] = in.nextInt();
		}
		
		for (int i=0;i<noOfElements;i++) {
			int j = i+1;
			int k = i-1;
			int element = heights[i];
			int area = element;
			while(k>=0) {
				if (heights[i] <= heights[k]) {
					area += element;
				} else {
					break;
				}
				k--;
			}
			while (j<noOfElements) {
				if(heights[i] <= heights[j]) {
					area += element;
				} else {
					break;
				}
				j++;
			}
			if (largestRectangle < area) {
				largestRectangle = area;
			}
		}
		
		System.out.println(largestRectangle);
		in.close();
	}

}
