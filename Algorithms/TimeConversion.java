package algorithms;

import java.util.*;

public class TimeConversion {

    static String timeConversion(String s) {
        String output = null;
    	if(s.contains("PM")) {
    		String[] parts = s.split(":");
    		String secondsPart = parts[2].substring(0, 2);
    		int hours = Integer.parseInt(parts[0]);
    		int minutes = Integer.parseInt(parts[1]);
    		int seconds = Integer.parseInt(secondsPart);
    		if (hours != 12) {
    			hours = hours + 12;
    		}
    		String newHours = (hours<10?"0":"") + hours;
    		String newMinutes = (minutes<10?"0":"") + minutes;
    		String newSeconds = (seconds<10?"0":"") + seconds;
    		output = newHours + ":" + newMinutes + ":" + newSeconds;
    	} else {
    		String[] parts = s.split(":");
    		String secondsPart = parts[2].substring(0, 2);
    		int hours = Integer.parseInt(parts[0]);
    		if (hours == 12) {
    			hours = 0;
    		}
    		int minutes = Integer.parseInt(parts[1]);
    		int seconds = Integer.parseInt(secondsPart);
    		String newHours = (hours<10?"0":"") + hours;
    		String newMinutes = (minutes<10?"0":"") + minutes;
    		String newSeconds = (seconds<10?"0":"") + seconds;
    		output = newHours + ":" + newMinutes + ":" + newSeconds;
    	}
    	return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
        in.close();
    }
}
