package algorithms;

import java.util.Scanner;

public class RichieRichV2 {

	public static String richieRich(String s, int n, int k) {
		String output = "-1";
		char[] letters = new char[s.length()];
		letters = s.toCharArray();
		int[] indices = new int[s.length()];
		int top = -1;
		int end = s.length()-1;
		boolean isFound = false;
		
		if(n == 1) {
			return "9";
		} else if (n % 2 != 0) {
			for(int i=0;i<((s.length())/2);i++,end--) {
				if(letters[i] == letters[end]) {
					continue;
				} else {
					indices[++top] = i;
					indices[++top] = end;
				}
			}
			if(k == 1 && top == -1) {
				int mid = n/2;
				indices[++top] = mid;
				char[] palindrome = new char[s.length()];
				palindrome = s.toCharArray();
				palindrome[mid] = '9';
				output = String.valueOf(palindrome);
				return output;
			}
		} else {
			for(int i=0;i<((s.length())/2);i++,end--) {
				if(letters[i] == letters[end]) {
					continue;
				} else {
					indices[++top] = i;
					indices[++top] = end;
				}
			}
		}
		
		/*if(top == -1) {
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
		}*/
		
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
			int j= 0;
			while(count < k && j <= top) {
				int firstIndex = indices[j];
				int secondIndex = indices[++j];
				if(palindrome[firstIndex] > palindrome[secondIndex]) {
					palindrome[secondIndex] = palindrome[firstIndex];
					count += 1;
					j++;
				} else {
					palindrome[firstIndex] = palindrome[secondIndex];
					j++;
					count += 1;
				}
				int last = s.length() - 1;
				for(int l=0;l<s.length();l++,last--) {
					reverse[l] = palindrome[last];
				}
				String s1 = String.valueOf(palindrome);
				String s2 = String.valueOf(reverse);
				if((s1.equals(s2))) {
					isFound = true;
					break;
				} else {
					continue;
				}
			}
			
			int firstIndex = -1;
			int lastIndex = s.length();
			if(k % 2 == 0) {
				while(count < k-1) {
					palindrome[++firstIndex] = element;
					palindrome[--lastIndex] = element;
					count += 2;
				}
			} else {
				while(count < k) {
					palindrome[++firstIndex] = element;
					palindrome[--lastIndex] = element;
					count += 2;
				}
			}
			if(isFound) {
				output = String.valueOf(palindrome);
			}
			break;
			/*if(count < k) {
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
			}*/
			
		}
		
		
		
		return output;
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
