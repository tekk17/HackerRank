package problems;

import java.util.Scanner;

public class PoisonousPlants {
	
	public static int[] plants = null;
	public static int noOfPlants;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		noOfPlants = in.nextInt();
		plants = new int[noOfPlants];
		
		for(int i=0;i<noOfPlants;i++) {
			plants[i] = in.nextInt();
		}
		
		int days = 0;
		int topOfStack = -1;
		int eliminatedCount = 0;
		int[] eliminateIndices = new int[noOfPlants];
		
		for(;;) {
			for(int i=1;i<(noOfPlants);i++) {
				if (plants[i] > plants[i-1]) {
					eliminateIndices[++topOfStack] = i;
				} else {
					continue;
				}
			}
			if (topOfStack != -1) {
				rearrange(eliminateIndices, topOfStack, eliminatedCount);
				eliminatedCount = topOfStack+1;
				topOfStack = -1;
				days+= 1;
				noOfPlants = noOfPlants - eliminatedCount;
				eliminateIndices = new int[noOfPlants];
			} else {
				break;
			}
		}
		System.out.println(days);
		in.close();
	}
	
	public static void rearrange(int[] eliminate,int noOfEliminations,int eliminatedCount) {
		for(int i=0;i<=noOfEliminations;i++) {
			int index = eliminate[i];
			if (i != 0) {
				index = eliminate[i] - i;
			}
			while(index<((noOfPlants)-1)) {
				plants[index++] = plants[index];
			}
		}
	}

}
