package dataStructures;

import java.util.Scanner;

public class PoisonousPlantsV2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfPlants = in.nextInt();
		int[] plants = new int[noOfPlants];
		int min = plants[0];
		int max = 0;
		int[] st = new int[noOfPlants];
		int top = -1;
		int[] days = new int[noOfPlants];
		
		for(int i=0;i<noOfPlants;i++) {
			plants[i] = in.nextInt();
		}
		
		st[++top] = 0;
		
		for(int i=1;i<noOfPlants;i++) {
			if (plants[i]>plants[i-1]) {
				days[i] = 1;
			}
			
			min = min<plants[i]?min:plants[i];
			
			while((!(top != -1)) && (plants[st[top]] >= plants[i])) {
				if (plants[i] > min) {
					days[i] = days[i] > days[top] + 1?days[i]:days[top] + 1;
			   }  
			top -= 1;
			max = max>days[i]?max:days[i];
			st[++top] = i;
			}
		}
		System.out.println(max);
		in.close();
	}
}