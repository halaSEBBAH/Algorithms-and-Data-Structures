import java.io.*;
import java.util.*;

class GraphBFS{
    int V;
    LinkedList<Integer> adj[];
    
    GraphBFS(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0; i<V ; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int i, int j){
        adj[i].add(j);
        adj[j].add(i);
    }

    void bfs(int s){
        
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        visited[s] = true;  
        System.out.println("le sommet "+s);

        stack.add(s);
        while(!stack.empty()){
            int now = stack.pop();
            for(int i = 0; i < adj[now].size(); i++){
                if(!visited[adj[now].get(i)]){
                    System.out.print(adj[now].get(i) + " ");
                    stack.add(adj[now].get(i));
                    visited[adj[now].get(i)] = true;
                }
            }
            System.out.print("\n");
        }
        

    }


}



public class GraphManipulation {



    

    public static void main(String[] args){

        GraphBFS gr = new GraphBFS(6);
        gr.addEdge(0, 1);
        gr.addEdge(2, 1);
        gr.addEdge(4, 1);
        gr.addEdge(2, 4);
        gr.addEdge(4, 5);
        gr.addEdge(5, 3);

        gr.bfs(5);
        
        
         

        
    } 

}
