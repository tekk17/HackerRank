package problems;

import java.util.Scanner;

public class BalancedBrackets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            char[] charArray = s.toCharArray();
            int len = s.length();
            char[] outputArray = new char[len];
            int topOfStack = -1;
            boolean isPrinted = false;
            int i = 0;
            for (i=0;i<len;i++) {
            	if (charArray[i] == '(') {
            		outputArray[++topOfStack] = charArray[i];
            		continue;
            	} 
            	if (charArray[i] == '[') {
            		outputArray[++topOfStack] = charArray[i];
            		continue;
            	}
            	if (charArray[i] == '{') {
            		outputArray[++topOfStack] = charArray[i];
            		continue;
            	}
            	if (charArray[i] == ')') {
            		if (topOfStack == -1) {
            			System.out.println("NO");
            			isPrinted = true;
            			break;
            		}
            		char toMatch = outputArray[topOfStack];
            		if (toMatch == '(') {
            			topOfStack -= 1;
            		} else {
            			System.out.println("NO");
            			isPrinted = true;
            			break;
            		}
            	} else if (charArray[i] == ']') {
            		if (topOfStack == -1) {
            			System.out.println("NO");
            			isPrinted = true;
            			break;
            		}
            		char toMatch = outputArray[topOfStack];
            		if (toMatch == '[') {
            			topOfStack -= 1;
            		} else {
            			System.out.println("NO");
            			isPrinted = true;
            			break;
            		}
            	} else if (charArray[i] == '}') {
            		if (topOfStack == -1) {
            			System.out.println("NO");
            			isPrinted = true;
            			break;
            		}
            		char toMatch = outputArray[topOfStack];
            		if (toMatch == '{') {
            			topOfStack -= 1;
            		} else {
            			System.out.println("NO");
            			isPrinted = true;
            			break;
            		}
            	}
            }
            if (topOfStack == -1 && i == len) {
            	System.out.println("YES");
            }
            if (topOfStack != -1 && !isPrinted) {
            	System.out.println("NO");
            }
        }
	}

}
