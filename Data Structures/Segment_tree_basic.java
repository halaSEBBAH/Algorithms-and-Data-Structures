import java.util.*;
/*
public class Segment_Tree {
		
	static int[] Tree;
	static int[] Arr;
	static int[] lazy;
	
	static int Compute(int a , int b) {return Math.max(a, b);}
	
	static void build(int node , int start , int end) {
		if(start == end) Tree[node] = Arr[start];
		else {
			int mid = (start+end)/2;
			build(2*node,start, mid);
			build(2*node+1, mid+1, end);
			Tree[node] = Compute(Tree[2*node],Tree[2*node+1]);
		}	
	}
	
	static int query(int node , int l , int r , int start , int end) {
		if(r < start || end < l ) return 0; // element neutre de l'opération
		else if(l<=start && end<=r) return Tree[node];
		else {
			int mid = (start +end)/2;
			return Compute(query(2*node, l,r, start, mid),query(2*node+1, l,r, mid+1, end));
		}
	}
	
	
	static void update(int node , int start , int end , int index , int val) {
		if(start == end) {
			Tree[node] += val;
			Arr[start] +=val;
		}else {
			int mid = (start+end)/2;
			if(index<=mid) update(2*node, start, mid, index, val);
			else update(2*node+1, mid+1, end, index, val);
			Tree[node] = Compute(Tree[2*node], Tree[2*node+1]);
		}
	}
	
	
	static void updateRange(int node ,int start ,int end ,int l, int r ,int val) {
		if(r < start || end < l) return ;
		else if(start == end) {
			Tree[node] += val;
			Arr[start] +=val;
		}else {
			int mid = (start+end)/2;
			updateRange(2*node, start, mid, l,r, val);
			updateRange(2*node+1, mid+1, end,  l,r, val);
			Tree[node] = Compute(Tree[2*node], Tree[2*node+1]);
		}
	}
	
	static void updateRangeLazy(int node ,int start ,int end ,int l, int r ,int val) {
		if(lazy[node] != 0) {
			Tree[node] += (end-start+1)*lazy[node];
			if(start != end) {
				lazy[2*node] += lazy[node];
				lazy[2*node+1] += lazy[node];
			}
		}
		lazy[node] = 0;
		if(r < start || end < l) return ;
		else if(l<=start && end<=r) {
			Tree[node]+=(end-start+1)*val;
			if(start != end) {
				lazy[2*node] += val;
				lazy[2*node+1] += val;
			}
			return;
		}
		int mid = (start+end)/2;
		updateRangeLazy(2*node,start,mid , l, r , val);
		updateRangeLazy(2*node,start,mid , l, r , val);
		Tree[node] = Tree[2*node]+Tree[2*node+1];		
	}
	
	
	
	static int queryRangeLazy(int node, int start, int end, int l, int r) {
		if(r < start || end < l) return 0;
		if(lazy[node] != 0) {
			Tree[node] += (end-start+1)*lazy[node];
			if(start != end) {
				lazy[2*node] += lazy[node];
				lazy[2*node+1] += lazy[node];
			}
		}
		return r;
		
	}
	
	
	public static void main(String[] args) {
		
		Arr = new int[] {2,5,8,9,4};
		int n = Arr.length;
		Tree = new int[2*n+5];
		
		lazy = new int[2*n+5];
		Arrays.fill(lazy,0);
		
		build(1,0,n-1);
		/*updateRange(1,0,n-1,1,3, -8);
		System.out.println(query(1,-1,6,0,n-1));*/
/*
		updateRangeLazy(1,0,n-1,1,3,-8);
		
		List<List<Integer>> res =  new LinkedList<>();
		res.add(new LinkedList<Integer>() {{add(1);add(3);}});
		System.out.println(res.contains(new LinkedList<Integer>() {{add(1);add(3);}}));
		
		
		
	}	
	
}
*/