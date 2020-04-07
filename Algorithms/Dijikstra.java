import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Edge{
	int to;
	int weight;
	
	public Edge(int to , int weight) {
		this.to = to;
		this.weight = weight;
	}
	
}	
	
	
class Graph{
	int V ;
	LinkedList<Edge> graphlist[];
	
	public Graph(int V) {
		this.V = V;
		graphlist = new LinkedList[V];
		for(int i = 0; i< V ; i++) {
			graphlist[i] = new LinkedList<Edge>();
		}
	}
	
	public void AddEdge(int from , int to , int weight) {
		Edge e = new Edge(to,weight);
		graphlist[from].add(e);
		
		/* if the graph is undirected */
		Edge eback = new Edge(from, weight);
		graphlist[to].add(eback);
	}
	
}



public class Dijikstra {
	
	public static int[] diji(Graph g ,int src) {
		
		int[] dist = new int[g.V];
		for(int i = 0; i<g.V; i++) dist[i] = Integer.MAX_VALUE;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Set<Integer> set = new TreeSet<Integer>();
		
		pq.add(src);
		dist[src] = 0;
		while(set.size()!= g.V) {
			
			if(pq.size()>0) {
				int u = pq.remove();
				set.add(u);
				visit_neighbors(g,u, dist, pq, set);
			}else break;				
		}
		return(dist);
		
	}
	
	public static void visit_neighbors(Graph g,int u, int[] dist , PriorityQueue<Integer> pq, Set<Integer> set) {
		
		int newDistance = 0;
		int kid ;
		for(int i = 0; i<g.graphlist[u].size();i++) {
			 kid = g.graphlist[u].get(i).to;
			 if(! set.contains(kid)) {
				 newDistance  = dist[u]+g.graphlist[u].get(i).weight;
				 if(newDistance < dist[g.graphlist[u].get(i).to]) dist[g.graphlist[u].get(i).to] = newDistance;
				 pq.add(kid);
			 }		 
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
		StringTokenizer tr = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(tr.nextToken());
		int m = Integer.parseInt(tr.nextToken());
		//int m = v-1;

		Graph g = new Graph(v);

		for(int i = 0; i<m ; i++){			
			tr = new StringTokenizer(br.readLine());
			g.AddEdge(Integer.parseInt(tr.nextToken()), Integer.parseInt(tr.nextToken()),Integer.parseInt(tr.nextToken()));
		}
		
		int[] res = diji(g,0);
		for(int i =0; i< g.V ; i++) System.out.println("distance de "+ 0+ " à " +i +" est "+res[i]);
	}

}
