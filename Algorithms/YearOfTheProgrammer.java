package algorithms;

import java.util.Scanner;

public class YearOfTheProgrammer {
	static String solve(int year){
        // Complete this function
        String result = null;
        if(year < 1918) {
            //Julian Calendar
            if(year % 4 == 0) {
                result = "12.09." + year;
            } else {
            	result = "13.09." + year;
            }
        }
        if(year == 1918) {
        	result = "26.09.1918";
        }
        if(year > 1918) {
        	if(((year % 400) == 0) || (((year %4)==0) && !(year%100==0))) {
        		result = "12.09." + year;
        	} else {
        		result = "13.09." + year;
        	}
        }
        return result;
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
	}

}
