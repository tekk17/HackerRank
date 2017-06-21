package problems;

public class SegTree {
	SegTree Node;
	int info;
	int start;
	int end;
	
	SegTree(int first, int last) {
		info = 0;
		start = first;
		end = last;
	}
}
