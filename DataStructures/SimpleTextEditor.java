package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleTextEditor {
		static String editorText = new String();//editor string
		static int delStack = -1;//used to store the no.Of deleted chars
		static int stringsAdded = -1;//to handle the added strings
		static List<String> delString = new ArrayList<String>();//list to store the strings deleted
		static int delStringStack = -1;//used to store the deleted strings
		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfOperation = in.nextInt();
		int operation[] = new int[noOfOperation];
		int appendPosition[] = new int[noOfOperation];//to store position of deleted strings
		int topOfAppendPosition = -1;
		int topOfStack = -1;//to handle operations done
		List<String> addedString = new ArrayList<String>();
		int noOfDeletions[] = new int[noOfOperation];
		for (int i=0;i<noOfOperation;i++) {
			int mode = in.nextInt();
			switch (mode) {
			case 1:
				//append to existing string
				String addString = in.next();
				editorText = editorText.concat(addString);
				//int newLength = editorText.length();
				//int addStringLength = addString.length();
				//int addedPosition = newLength - addStringLength;
				//appendPosition[++topOfAppendPosition] = addedPosition;
				operation[++topOfStack] = mode;
				addedString.add(addString);
				stringsAdded++;
				break;

			case 2:
				//delete from the string k no of characters
				int noOfCharacters = in.nextInt();
				operation[++topOfStack] = mode;
				int position = deleteChars(noOfCharacters);
				appendPosition[++topOfAppendPosition] = position;
				noOfDeletions[++delStack] = noOfCharacters;
				break;
			
			case 3:
				//print the kth character of string
				int charAtPosition = in.nextInt();
				char tobePrinted = editorText.charAt(charAtPosition-1);
				System.out.println(tobePrinted);
				break;
				
			case 4:
				//undo the last operation
				if (topOfStack == -1) 
					break;
				int lastOperation = operation[topOfStack--];
				if (lastOperation == 1) {
					//delete the chars added
					//int toGet = topOfStack+1;
					String strToDelete = addedString.get(stringsAdded);
					addedString.remove(stringsAdded);
					stringsAdded--;
					deleteString(strToDelete);
				} else {
					//add the chars deleted
					String toReAdd = delString.get(delStringStack);
					int positionToAdd = appendPosition[topOfAppendPosition--];
					//call method to add string
					insertDeletedString(positionToAdd, toReAdd);
					delString.remove(delStringStack);
					delStringStack--;
					
				}
			default:
				break;
			}
		}
		in.close();
	}
	
	public static int deleteChars(int count) {
		int len = editorText.length();
		int strTopOfStack = editorText.length() -1;
		strTopOfStack = strTopOfStack - count;
		String strDelList = editorText.substring(strTopOfStack+1, len);
		delString.add(strDelList);
		delStringStack += 1;
		if (strTopOfStack == -1) {
			editorText = "";		
		} else {
			editorText = editorText.substring(0, strTopOfStack+1);
		}
		return strTopOfStack+1;
	}
	
	public static void deleteString (String strDel) {
		int len = strDel.length();
		int strTopOfStack = editorText.length() -1;
		strTopOfStack = strTopOfStack - len;		
		if (strTopOfStack == -1) {
			editorText = "";
		} else {
			editorText = editorText.substring(0, strTopOfStack+1);
		}
	}
	
	public static void insertDeletedString (int position, String tobeReAdded) {
		int editorTextLength = editorText.length();
		int tobeReAddedLength = tobeReAdded.length();
		int newEditorTextLength = editorTextLength + tobeReAddedLength;
		char editorTextArray[] = new char[newEditorTextLength];
		char editorStringArray[] = editorText.toCharArray();
		//editorTextArray = editorText.toCharArray();
		char toBeReAddedChars[] = new char[tobeReAddedLength];
		toBeReAddedChars = tobeReAdded.toCharArray();
		
		while(editorTextLength > position) {
			editorTextArray[--newEditorTextLength] = editorStringArray[--editorTextLength];
		}
		/*if (editorTextLength == 0) {
			--editorTextLength;
			editorTextArray = new char[newEditorTextLength];
		}*/
		for (int i=0;i<position;i++) {
			editorTextArray[i] = editorStringArray[i];
		}
		for(int i=0;i<tobeReAddedLength;i++) {
			editorTextArray[editorTextLength++] = toBeReAddedChars[i];
		}
		//editorText = editorTextArray.toString();
		editorText = String.valueOf(editorTextArray);
	}

}
