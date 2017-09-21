package algorithms;

import java.util.Scanner;

public class CommonChild {

	public static int commonChild(String s1, String s2){
		int[] s1Frequencies = new int[26];
		int[] s2Frequencies = new int[26];
		char[] letters1 = new char[s1.length()];
		letters1 = s1.toCharArray();
		char[] letters2 = new char[s2.length()];
		letters2 = s2.toCharArray();
		int count = 0;
		int[][] runningFreqs = new int[26][2];
		
		for(int i=0;i<s1.length();i++) {
			int element = (int) letters1[i] - 65;
			s1Frequencies[element] += 1;
		}
		
		for(int i=0;i<s2.length();i++) {
			int element = (int) letters2[i] - 65;
			s2Frequencies[element] += 1;
		}
		
		for(int i=0;i<26;i++) {
			if(s1Frequencies[i] != 0 && s2Frequencies[i] != 0) {
				runningFreqs[i][0] = s1Frequencies[i];
				runningFreqs[i][1] = s2Frequencies[i];
			}
		}
		
		int[] common = new int[26];
		for(int i=0;i<26;i++) {
			if((s1Frequencies[i] >= 1) && (s2Frequencies[i] >= 1)) {
				common[i] = 1;
			}
		}
		
		char[] commonS1 = new char[s1.length()];
		int top1 = -1;
		for(int i=0;i<s1.length();i++) {
			int letter = (int) letters1[i] - 65;
			if(common[letter] == 1) {
				commonS1[++top1] = letters1[i];
			}
		}
		
		char[] commonS2 = new char[s1.length()];
		int top2 = -1;
		for(int i=0;i<s2.length();i++) {
			int letter = (int) letters2[i] - 65;
			if(common[letter] == 1) {
				commonS2[++top2] = letters2[i];
			}
		}
		
		for(int i=0;i<=top1;i++) {
			char[] output = new char[s1.length()+s2.length()];
			int top = -1;
			int running = 0;
			int len1 = i;
			int len2 = 0;
			int[][] currFreqs = new int[26][2];
			int letter1 = (int) commonS1[i] - 65;
			runningFreqs[letter1][0] -= 1;
			for(int m=0;m<26;m++) {
				currFreqs[m][0] = runningFreqs[m][0];
				currFreqs[m][1] = runningFreqs[m][1];
			}
			while(len1 <= top1 && len2 <= top2) {
				//System.out.println("L1:" + commonS1[len1]);
				//System.out.println("L2:" + commonS2[len2]);
				letter1 = (int) commonS1[len1] - 65;
				int letter2 = (int) commonS2[len2] - 65;
				if(letter1 == letter2) {
					output[++top] = (char) (letter2+65);
					len1++;
					len2++;
					running++;
					currFreqs[letter1][0] -= 1;
					currFreqs[letter2][1] -= 1;
					continue;
				} else {
					if(currFreqs[letter2][0] == 0) {
						len1++;
						continue;
					} else if(currFreqs[letter1][1] == 0) {
						len2++;
						continue;
					} else if((currFreqs[letter1][0] >= 1) && (currFreqs[letter1][1] >= 1)) {
						currFreqs[letter2][1] -= 1;
						len2++;
						continue;
					} else {
						currFreqs[letter1][0] -= 1;
						len1++;
						continue;
					} 
				}
			}
			if(running > count) {
				count = running;
			}
		}
		
		return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
        in.close();
    }
}
