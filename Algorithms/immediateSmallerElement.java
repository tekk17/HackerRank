package easy;

import java.util.Scanner;

public class immediateSmallerElement {

	public static int[] findImmediateSmallerElement(int[] input) {
		int[] output = new int[input.length];
		int noSmallElement = -1;
		output[(input.length)-1] = noSmallElement;
		for(int i=0;i<(input.length)-1;i++) {
			if(input[i+1] < input[i]) {
				output[i] = input[i+1];
			} else {
				output[i] = noSmallElement;
			}
		}
		return output;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTests = in.nextInt();
		for(int k=0;k<noOfTests;k++) {
			int size1 = in.nextInt();
			int[] input = new int[size1];
			for(int i=0;i<size1;i++) {
				input[i] = in.nextInt();
			}
			int[] output = findImmediateSmallerElement(input);
			for(int j =0;j<size1;j++) {
				System.out.print(output[j] + " ");
			}
			System.out.println();
		}
	}
}
