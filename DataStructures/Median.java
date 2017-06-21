package problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.math.BigDecimal;

import org.omg.CORBA.FREE_MEM;

class Median{
	//static List<Integer> medianList = new ArrayList<Integer>();
	long info;
	Median link;
	static Median currPtr;
	static Median startPtr;
	static boolean isFirstNode = false;
	
	public static void Insert(long element) {
		Median prevPtr = null;
		if(!isFirstNode) {
			//create your first node
			Median parent = new Median();
			parent.info = element;
			parent.link = null;
			startPtr = parent;
			isFirstNode = true;
		} else {
			Median node = new Median();
			currPtr = startPtr;
			prevPtr = currPtr;
			//Median prevPtr = null;
			while(currPtr != null) {
				if(element > currPtr.info) {
					prevPtr = currPtr;
					currPtr = currPtr.link;
				} else {
					break;
				}
			}
			if (currPtr == startPtr) {
				node.info = element;
				node.link = startPtr;
				startPtr = node;
			} else {
				node.info = element;
				node.link = prevPtr.link;
				prevPtr.link = node;
			}
		}
	}
	
	public static int getListSize() {
		currPtr = startPtr;
		int counter = 0;
		while(currPtr != null) {
			currPtr = currPtr.link;
			counter++;
		}
		return counter;
	}
	
	public static long getNodeInfo(int position) {
		currPtr = startPtr;
		long data = 0;
		int i = 0;
		while(currPtr != null) {
			if (i == position) {
				data = currPtr.info;
				break;
			} else {
				currPtr=currPtr.link;
				i++;
			}
		}
		
		return data;
	}
	
	public static void removeInfo(long element) {
		if (startPtr.info == element && element == 0) {
			startPtr = startPtr.link;
			System.gc();
			return;
		} else if(startPtr.info == element && startPtr.info > 0 && element > 0) {
			startPtr = startPtr.link;
			System.gc();
			return;
		} else if(startPtr.info == element && startPtr.info < 0 && element < 0) {
			startPtr = startPtr.link;
			System.gc();
			return;
		}
		
		if(startPtr == null) {
			isFirstNode = false;
			return;
		}
		currPtr = startPtr;
		Median prevPtr = currPtr;
		boolean wasDeleted = false;
		while(currPtr != null) {
			if (currPtr.info == element && element == 0) {
				currPtr = currPtr.link;
				prevPtr.link = currPtr;
				wasDeleted = true;
				break;
			} else if(currPtr.info == element && currPtr.info > 0 && element > 0) {
				currPtr = currPtr.link;
				prevPtr.link = currPtr;
				wasDeleted = true;
				break;
			} else if(currPtr.info == element && currPtr.info < 0 && element < 0) {
				currPtr = currPtr.link;
				prevPtr.link = currPtr;
				wasDeleted = true;
				break;
			} else {
				prevPtr = currPtr;
				currPtr = currPtr.link;
			}
		}
		/*if (wasDeleted) {
			return true;
		} else {
			return false;
		}*/
	}
	
	public static boolean isInfopresent(int element) {
		boolean isPresent = false;
		currPtr = startPtr;
		while(currPtr != null) {
			if (currPtr.info == element && element == 0) {
				isPresent = true;
				break;
			} else if(currPtr.info == element && currPtr.info > 0 && element > 0) {
				isPresent = true;
				break;
			} else if(currPtr.info == element && currPtr.info < 0 && element < 0) {
				isPresent = true;
				break;
			} else {
				currPtr = currPtr.link;
			}
		}
		return isPresent;
	}
	
    /* Head ends here*/
    static void findMedian(String a[],int x[], int count) {
    	//List<Integer> medianList = new ArrayList<Integer>();
    	int removeCount = 0;
    	int addCount = 0;
    	
    	for(int i=0;i<count;i++) {
    		if (a[i].equals("a")) {
    			Median.Insert(x[i]);;
    			addCount = Median.getListSize();
    			if (addCount == 1) {
    				System.out.println(Median.getNodeInfo(addCount-1));
    			} else if (addCount > 1) {
    				returnMedianValue(addCount);
    				//System.out.println(addMedian);
    			}
    		} else {
    			if (Median.isInfopresent(x[i])) {
    				Median.removeInfo(x[i]);
    				removeCount = Median.getListSize();
    				if (removeCount == 0) {
    					System.out.println("Wrong!");
    				}
    				else if (removeCount == 1) {
    					System.out.println(Median.getNodeInfo(removeCount-1));
    				} else if (removeCount>1) {
    					//call your method here and return median;return the index of mid
    					returnMedianValue(removeCount);
    					//System.out.println(removeMedian);
    				}
    			} else {
    				System.out.println("Wrong!");
    			}
    		}
    	}
    }
    
    public static void returnMedianValue(int currentListCount) {
    	PrintWriter pw = new PrintWriter(System.out, true);
    	int remainder = currentListCount % 2;;
    	int midVal = 0;
    	int midValPlus = 0;
    	boolean isEven = false;
    	boolean isOdd = false;
    	long listElement1 = 0;
    	long listElement2 = 0;
    	double median = 0;
    	if(remainder == 0) {
    		isEven = true;
    	} else {
    		isOdd = true;
    	}
    	
    	if(isEven) {
    		midVal = currentListCount/2;
    		midValPlus = midVal + 1;
    		listElement1 = Median.getNodeInfo(midVal-1);
    		listElement2 = Median.getNodeInfo(midValPlus-1);
    		median = (double)(listElement1+listElement2)/(double)(2);
    		if ((median == Math.floor(median)) && !Double.isInfinite(median)) {
    			long printMedian = (long)median;
        		//System.out.println(BigDecimal.valueOf(printMedian).toPlainString());
    			pw.println(BigDecimal.valueOf(printMedian).toPlainString());
    		} else {
    			//System.out.println(BigDecimal.valueOf(median).toPlainString());
    			pw.println(BigDecimal.valueOf(median).toPlainString());
    		}
    	} else if(isOdd) {
    		midVal = currentListCount/2;
    		median = (long)Median.getNodeInfo(midVal);
    		long printMedian = (long)median;
    		//System.out.println(printMedian);
    		pw.println(printMedian);
    	}
    	//return median;
    }
    
    /* Tail starts here*/
    
   public static void main( String args[] ){
	   Scanner in = new Scanner(System.in);
      
	   int N;
	   N = in.nextInt();
   
	   String s[] = new String[N];
	   int x[] = new int[N];
      
	   for(int i=0; i<N; i++){
		   s[i] = in.next();
		   x[i] = in.nextInt();
	   }
   
	   findMedian(s,x,N);
      
	   in.close();
   }
}
