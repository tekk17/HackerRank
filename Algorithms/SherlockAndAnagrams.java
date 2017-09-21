package algorithms;

import java.util.Scanner;

public class SherlockAndAnagrams {
	
	public static int sherlockAndAnagrams(String s){
		int count = 0;
		char[] letters = new char[s.length()];
		letters = s.toCharArray();
		int[] alphabets = new int[26];
		
		boolean noRepeats = false;
		for(int i=0;i<s.length();i++) {
			int letter = (int) letters[i] - 97;
			alphabets[letter] += 1;
			if(alphabets[letter] >=2) {
				noRepeats = true;
			}
		}
		
		if(!noRepeats) {
			return 0;
		}
		
		int traversal = 0;//s.length()-2;
		int top = -1;
		
		while(traversal <=s.length()-2) {
			int i=0;
			int j=i+1;
			String[] strings = new String[s.length()];
			while((j+traversal) <= s.length()) {
				strings[++top] = s.substring(i,j+traversal);
				i += 1;
				j += 1;
			}
			count += compareStrings(strings, top, traversal);
			traversal += 1;
			top = -1;
		}
		return count;
    }
	
	public static int compareStrings(String[] str, int top, int val) {
		int counter = 0;
		for(int i=0;i<top;i++) {
			char[] str1 = str[i].toCharArray();
			int[] letterFrequency1 = new int[26];
			for(int u=0;u<=val;u++) {
				int frequency = (int) str1[u] - 97;
				letterFrequency1[frequency] += 1;
			}
			for(int j=i+1;j<=top;j++) {
				if(str[i].equals(str[j])) {
					counter += 1;
					continue;
				}
				char[] str2 = str[j].toCharArray();
				int[] letterFrequency2 = new int[26];
				boolean isEqual = true;
				for(int v=0;v<=val;v++) {
					int frequency = (int) str2[v] - 97;
					letterFrequency2[frequency] += 1;
				}
				for(int w=0;w<26;w++) {
					if(letterFrequency1[w] != 0) {
						if(letterFrequency1[w] == letterFrequency2[w]) {
							continue;
						} else {
							isEqual = false;
							break;
						}
					}
				}
				if(isEqual) counter += 1;
			}
		}
		
		return counter;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
        in.close();
    }

}
