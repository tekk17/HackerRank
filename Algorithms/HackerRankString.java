package algorithms;

import java.util.Scanner;

public class HackerRankString {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int length = s.length();
            
            char[] letters = new char[length];
            letters = s.toCharArray();
            int[] truthValues = new int[10];
            int top = -1;
            boolean foundH = false;
            boolean firstA = false;
            boolean foundC = false;
            boolean firstK = false;
            boolean foundE = false;
            boolean firstR = false;
            boolean secondR = false;
            boolean secondA = false;
            boolean foundN = false;
            boolean secondK = false;
            
            for(int i=0;i<length;i++) {
            	if(letters[i] == 104){
            		if(!foundH) {
            			truthValues[++top] = 1;
            			foundH = true;
            		}
            	} else if(letters[i] == 97) {
            		if(!firstA) {
            			if(truthValues[0] == 1) {
            				truthValues[++top] = 1;
            				firstA = true;
            			}
            		} else if(!secondA) {
            			if(truthValues[6] == 1) {
            				truthValues[++top] = 1;
            				secondA = true;
            			}
            		}
            	} else if(letters[i] == 99) {
            		if(!foundC) {
            			if(truthValues[1] == 1) {
                			truthValues[++top] = 1;
                			foundC = true;
                		}
            		}
            	} else if(letters[i] == 107) {
            		if(!firstK) {
            			if(truthValues[2] == 1) {
            				truthValues[++top] = 1;
                			firstK = true;
            			}
            		} else if(!secondK) {
            			if(truthValues[8] == 1) {
            				truthValues[++top] = 1;
            				secondK = true;
            				break;
            			}
            		}
            	} else if(letters[i] == 101) {
            		if(!foundE) {
            			if(truthValues[3] == 1) {
                			truthValues[++top] = 1;
                			foundE = true;
                		}
            		}
            		
            	} else if(letters[i] == 114) {
            		if(!firstR) {
            			if(truthValues[4] == 1) {
            				truthValues[++top] = 1;
            				firstR = true;
            			}
            		} else if(!secondR) {
            			if(truthValues[5] == 1) {
            				truthValues[++top] = 1;
            				secondR = true;
            			}
            		}
            	} else if(letters[i] == 110) {
            		if(!foundN) {
            			if(truthValues[7] == 1) {
                			truthValues[++top] = 1;
                			foundN = true;
                		}
            		}
            		
            	}
            }
            
            String result = "YES";
            for(int i=0;i<10;i++) {
            	if(truthValues[i] == 0) {
            		result = "NO";
            		break;
            	} else {
            		continue;
            	}
            }
            System.out.println(result);
        }
    in.close();
    }
	
}
