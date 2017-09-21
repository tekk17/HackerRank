package algorithms;

import java.util.Scanner;

public class GemStones {

	static int gemstones(String[] arr, int n){
        String s1 = arr[0];;
        int length = s1.length();
        char[] letters = new char[length];
        letters = s1.toCharArray();
        for(int i=1;i<n;i++) {
        	String s = arr[i];
        	int len = s.length();
        	char[] letterSet = new char[len];
        	letterSet = s.toCharArray();
        	String outputString = new String();
        	for(int j=0;j<length;j++) {
        		boolean isContains = isPresent(outputString, letters[j]);
        		if(!isContains) {
        			for(int k=0;k<len;k++) {
            			if(letters[j] == letterSet[k]) {
            				outputString = outputString+letters[j];
            				break;
            			}
            		}
        		}
        	}
        	length = outputString.length();
        	letters = outputString.toCharArray();
        }
        
        return length;
    }
	
	public static boolean isPresent(String alpha, char letter) {
		boolean isPresent = false;
		int len = alpha.length();
		char[] alphabets = new char[len];
		alphabets = alpha.toCharArray();
		for(int i=0;i<len;i++) {
			if(alphabets[i] == letter) {
				isPresent = true;
				return isPresent;
			}
		}
		return isPresent;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }
        int result = gemstones(arr,n);
        System.out.println(result);
        in.close();
    }
}
