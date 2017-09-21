package algorithms;

import java.util.Scanner;

public class RichieRich {

	public static String richieRich(String s, int n, int k){
		if(s.length() == 1) {
			return "9";
		}
		
		/*if(n > s.length()) {
			s = "9" + s;
		}*/
		
		if(n <= k) {
			char[] outputChars = new char[s.length()];
			for(int i=0;i<s.length();i++) {
				outputChars[i] = '9';
			}
			String returnOutput = String.valueOf(outputChars);
			return returnOutput;
		}
		
		char[] letters = new char[s.length()];
		letters = s.toCharArray();
		int[] indices = new int[s.length()];
		int top = -1;
		int end = s.length()-1;
		String output = "-1";
		
		for(int i=0;i<((s.length())/2);i++,end--) {
			if(letters[i] == letters[end]) {
				continue;
			} else {
				indices[++top] = i;
				indices[++top] = end;
			}
		}
		
		if(top == -1) {
			if(k == 1) {
				if(s.length()%2 == 0) {
					int mid = s.length()/2;
					indices[++top] = mid-1;
					indices[++top] = mid;
				} else {
					int mid = s.length()/2;
					indices[++top] = mid;
				}
			} else {
				end = s.length()-1;
				for(int i=0;i<((s.length())/2);i++,end--) {
					indices[++top] = i;
					indices[++top] = end;
				}
			}
		}
		
		if(top < k) {
			end = s.length()-1;
			if(s.length()%2 == 0) {
				for(int i=0;i<(((s.length())/2)-1);i++,end--) {
					if(!isIndexPresent(indices, top, i)) {
						indices[++top] = i;
						indices[++top] = end;
					}
				}
			} else {
				for(int i=0;i<((s.length())/2);i++,end--) {
					if(!isIndexPresent(indices, top, i)) {
						indices[++top] = i;
						indices[++top] = end;
					}
				}
			}
		}
		int substitute = 57;
		for(;;) {
			if(substitute < 48) {
				return "-1";
			}
			int count = 0;
			char element = (char) 57 ;
			substitute -= 1;
			char[] palindrome = new char[s.length()];
			palindrome = s.toCharArray();
			char[] reverse = new char[s.length()];
			int j=0;
			if(s.length() % 2 == 0) {
				int index1 = s.length()/2;
				int index2 = index1 - 1;
				if(isIndexPresent(indices, index1, top)) {
					j++;
				}
				if(isIndexPresent(indices, index2, top)) {
					j++;
				}
				if((int)palindrome[index1] != (int)palindrome[index2]) {
					if((int)palindrome[index1] > (int)palindrome[index2]) {
					 	palindrome[index2] = palindrome[index1];
						count += 1;
				 	} else {
						palindrome[index1] = palindrome[index2];
						count+= 1;
					}
				}
			}
			/*if(count % k != 0) {
				count += 1;
			}*/
			while(count < k && j<= top) {
				if(palindrome[indices[j]] == element) {
					j++;
					//count += 1;
					continue;
				} else {
					palindrome[indices[j]] = element;
					j++;
					count += 1;
				}
			}
			if(count < k) {
				for(int m=0;m<s.length();m++) {
					for(int p=0;p<=top;p++) {
						if(m == indices[p]) {
							continue;
						} else {
							palindrome[m] = element;
							break;
						}
					}
					if(count == k) {
						break;
					} else {
						count ++;
					}
				}
			}
			int last = s.length() - 1;
			for(int l=0;l<s.length();l++,last--) {
				reverse[l] = palindrome[last];
			}
			String p1 = String.valueOf(palindrome);
			String p2 = String.valueOf(reverse);
			if(p1.equals(p2)) {
				output = p1;
				break;
			}
		}
		return output;
		
    }
	
	public static boolean isIndexPresent(int[] indexValues, int size, int value) {
		boolean isPresent = false;
		for(int i=0;i<=size;i++) {
			if(indexValues[i] == value) {
				isPresent = true;
				break;
			}
		}
		return isPresent;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String result = richieRich(s, n, k);
        System.out.println(result);
        in.close();
    }
}
