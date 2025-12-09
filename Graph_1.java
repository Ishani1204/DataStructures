import java.util.*;
public class Graph_1 {
//Class to create a graph
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

//Creae graph function
static void createGraph(ArrayList<Edge> graph[]){
    for(int i=0; i<graph.length; i++){
        graph[i] = new ArrayList<>();
       }
       //0->vertex
       graph[0].add(new Edge(0, 1, 5));
      
       //1->vertex
       graph[1].add(new Edge(1, 2, 1));
       graph[1].add(new Edge(1, 3, 3));
       graph[1].add(new Edge(1, 0, 5));
      
       //2->vertex
       graph[2].add(new Edge(2, 1, 1));
       graph[2].add(new Edge(2, 3, 1));
       graph[2].add(new Edge(2, 4, 2));
      
       //3->vertex
       graph[3].add(new Edge(3, 1, 3));
       graph[3].add(new Edge(3, 2, 1));
      
       //4->vertex
       graph[4].add(new Edge(4, 2, 2));

}

//BFS Traversal - O(V+E)
public static void bfs(ArrayList<Edge>[] graph){
    Queue<Integer> q = new LinkedList<>();
    boolean vis[] = new boolean[graph.length];
    q.add(0); //source h ye humara

    while(!q.isEmpty()){
        int curr = q.remove();
        if(!vis[curr]){ //visit karenge
           System.out.println(curr+" ");
           vis[curr] = true;
           //Immediate neighbors visit
           for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            q.add(e.dest);
           }
        }
    }
}

//DFS Traversal - O(V+E)
public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]){
    //visit
    System.out.print(curr+" ");
    vis[curr] = true;
    for(int i=0; i<graph[curr].size(); i++){
        Edge e = graph[curr].get(i);
        if(!vis[curr]){
            dfs(graph, e.dest, vis);
        }
    }
}

//Has Path - O(V+E)
public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]){
    if(src==dest){
        return true;
    }

    for(int i=0; i<graph[src].size(); i++){
        Edge e= graph[src].get(i);

        //e.dest = neighbour
        if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
            return true;
        }
    }
    return false;
}
public static void main(String args[]){
    
/*              (5)
           0-----------1
                      / \
                  (1)/   \(3)     -------------->  Representation Of Graph
                    /     \
                   2-------3
                   |   (1)
                (2)|
                   |
                   4         
*/

/*Now we will should know how many vertices we have to store.
Because jo hum adjacency list banayenge usme vertices ka list banaya h 
phir un vertices se jo edges connected h wo alag se store ho rhe h so
basically we will store the number of vertices or utne hi size ka hume array banayenge.
*/
   int v = 5;
   ArrayList<Edge>[] graph = new ArrayList[v]; 
/*This is null AL means pta nhi h ki kya stored h
to hum ise empty AL banyenge*/
   createGraph(graph);

//To find the neighbours of a certain edge - 2's Neighbors
       for(int i=0; i<graph[2].size(); i++){
        Edge e = graph[2].get(i);
        System.out.println(e.dest);
       }
    bfs(graph);
    dfs(graph, 0, new boolean[v]);

    System.out.println(hasPath(graph, 0, 5, new boolean[v]));
    }
}
