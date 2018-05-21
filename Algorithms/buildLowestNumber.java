package easy;

import java.util.Scanner;

public class buildLowestNumber {

	public static String lowestNumber(String num, int k){
		String result = num;
		int i = 0;
		for(i=0; i<k; i++){
			int index;
			for(index=0; index < result.length()-1; index++){
				if(result.charAt(index) > result.charAt(index+1)){
					result = result.substring(0, index) + result.substring(index+1, result.length());
					break;
				}
			}
			if(index == result.length()-1){
				//result = result.substring(0, result.length()-1);
				return result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		for(int i=0;i<tests;i++) {
			String digits = in.next();
			int operations = in.nextInt();
			//startBuildingNumber(digits,operations);
			String result = lowestNumber(digits,operations);
			System.out.println(result);
		}
	}
}
