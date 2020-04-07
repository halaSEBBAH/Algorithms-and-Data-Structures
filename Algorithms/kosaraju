import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class kosaraju{
	
	static Stack<Integer> stack;
	static int sol = 0;
	
	int V;
	LinkedList<Integer> graphList [];	
	
	
	public kosaraju(int V){
		this.V = V;
		this.graphList= new LinkedList[V];
		for (int i = 0; i<V ; i++) {
			graphList[i] = new LinkedList<>();
		}	
	}
	
	static void addEdge(kosaraju g , int src , int dest ) {
		g.graphList[src].add(dest);
		//g.graphList[dest].add(src);
	}
	
		
	static void DFS(kosaraju g, Stack<Integer> stack , int n , boolean[] visited) {
		visited[n] = true;
		int i = 0;
		while(i < g.graphList[n].size() && g.graphList[n].get(i)!= null) {
			if(!visited[g.graphList[n].get(i)]) {
				DFS(g, stack,g.graphList[n].get(i),visited);
			}
			i++ ;
		}
		if(!stack.contains(n)) stack.push(n);
	}
	
	
	static void DFSRetour(kosaraju g,  int n , boolean[] visited) {
		visited[n] = true;
		System.out.print(n+" ");
		int i = 0;
		while(i < g.graphList[n].size() && g.graphList[n].get(i)!= null) {
			if(!visited[g.graphList[n].get(i)]) {
				DFSRetour(g,g.graphList[n].get(i),visited);
			}
			i++;
		}
	}
	
	
	
	static void Retour(kosaraju g, boolean[] visited ) {
		System.out.println("\nles noeuds dans chaque strongly connected componant sont : ");
		while(!stack.isEmpty()) {
			int start = stack.lastElement();
			stack.pop();
			if(!visited[start]) {
				System.out.print("-- ");
				DFSRetour(g,start, visited);
				sol++;
				System.out.println("");
			}
			if(!stack.isEmpty()) start = stack.lastElement();
		}
	}
	
	
	static ArrayList<Integer> Path(kosaraju g , int node , int nodeWanted, boolean visited[], ArrayList<Integer> path ){ 
		visited[node] = true ;
		path.add(node);
		ArrayList<Integer> p = new ArrayList<Integer>(); 
		ArrayList<Integer> d = new ArrayList<Integer>(); 
		if(node == nodeWanted) return path; 
		for(int i =  0  ;i< g.graphList[node].size();i++){
			if(!visited[g.graphList[node].get(i)]){
				p = Path(g, g.graphList[node].get(i), nodeWanted, visited, path);
                if(p.size() > 0) d = p ; 
			}
		}
		return d ;  
	}
	
	
	
	
	public static void main(String[]Args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tr = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(tr.nextToken()); 
		int edg = Integer.parseInt(tr.nextToken()); 
		
		kosaraju g = new kosaraju(V);
		kosaraju gtrans = new kosaraju(V);
		
		
		while(edg-->0) {
			tr = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(tr.nextToken());
			int to  = Integer.parseInt(tr.nextToken());
			addEdge(g,from, to);
			addEdge(gtrans, to,from);
		}
		
		boolean[] visited = new boolean[V];
		boolean[] visitedBack = new boolean[V];
		
		stack = new Stack<>();
		
		for(int i = 0; i<V ; i++) {
			DFS(g,stack,i,visited );
		}
		
		
		Retour(gtrans,visitedBack);
		
		System.out.println("le nombre de strongly connected components : " + sol);
		
		int rank = V-sol;
		System.out.println("le rank du graph est " +rank);
		
		
		visitedBack = new boolean[V];
		ArrayList<Integer> path  = new ArrayList<Integer>();

		Set<Integer> res = (Set<Integer>) Path(g ,0 ,4,visitedBack,path);
		System.out.println(res);
		
	}
	
}

