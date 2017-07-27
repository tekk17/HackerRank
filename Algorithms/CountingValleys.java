package algorithms;

import java.util.Scanner;

public class CountingValleys {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int noOfSteps = in.nextInt();
		String step = new String();
		step = in.next();
		char[] steps = step.toCharArray();
		int count = 0;
		int stepUp = 0;
		int stepDown = 0;
		
		for(int i=0;i<noOfSteps;i++) {
			if(steps[i] == 'U') {
				stepUp += 1;
			} else {
				stepDown += 1;
			}
			int diff = stepUp - stepDown;
			if (diff == 0 && steps[i] == 'U') {
				count += 1;
			}
		}
		
		System.out.println(count);
		in.close();

	}

}
