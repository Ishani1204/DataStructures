import java.util.*;
public class Graph_2 {
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

//Create graph function
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
//Modified BFS Traversal 
public static void bfs(ArrayList<Edge>[] graph){
    boolean vis[] = new boolean[graph.length];
    for(int i=0; i<graph.length; i++){
        bfsUtil(graph, vis);
    }
}
public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]){
    Queue<Integer> q = new LinkedList<>();
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

//Modified DFS Traversal 
public static void dfs(ArrayList<Edge>[] graph){
    boolean vis[] = new boolean[graph.length];
    for(int i=0; i<graph.length; i++){
        dfsUtil(graph, i, vis);
    }
}
public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]){
    //visit
    System.out.print(curr+" ");
    vis[curr] = true;
    for(int i=0; i<graph[curr].size(); i++){
        Edge e = graph[curr].get(i);
        if(!vis[curr]){
            dfsUtil(graph, e.dest, vis);
        }
    }
}

//Detect Cycle - O(V+E) 
public static boolean detectCycle(ArrayList<Edge>[] graph){
    boolean vis[] = new boolean [graph.length];
    for(int i=0; i<graph.length; i++){
        if(!vis[i]){
            if(detectCycleUtil(graph, vis, i, -1)){
                return true;
                //cycle exists in one of the parts
            }
        }
    }
    return false;
}

public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par){
    vis[curr]= true;
    for(int i=0; i<graph[curr].size(); i++){
        Edge e = graph[curr].get(i);
        //case 3
        if(!vis[e.dest]){
            if(detectCycleUtil(graph, vis, e.dest, curr)){
            return true;
           } 
        }
        //case 1
        else if(vis[e.dest] && e.dest != par){
            return true;
        }
        //case 2 -> do nothing basicall continue check
        }
        return false;
}

//Bipartite Graph
public static boolean isBipartite(ArrayList<Edge>[] graph){
    int col[]= new int[graph.length];
    for(int i=0; i<col.length; i++){
        col[i] = -1; // no colour
    }
    Queue<Integer> q = new LinkedList<>();
    for(int i=0; i<graph.length; i++){
        if(col[i] == -1){
            //BFS
            q.add(i);
            col[i] = 0; //yellow
            while(!q.isEmpty()){
                int curr = q.remove();
                for(int j=0; j<graph[curr].size(); j++){
                    Edge e = graph[curr].get(j); //e.dest
                    if(col[e.dest] == -1){
                        int nextCol = col[curr] == 0 ? 1 : 0;
                        col[e.dest]= nextCol;
                        q.add(e.dest);
                    } else if (col[e.dest] ==col[curr]){
                        return false;
                    }
                }
            }

        }
    }
    return true;
}

//Detect Cycle in a directed graph - O(V+E)
public static boolean IsCycle(ArrayList<Edge>[] graph){
    boolean vis[] = new boolean[graph.length];
    boolean stack[] = new boolean[graph.length];

    for(int i=0; i<graph.length; i++){
        if(!vis[i]){
            if(isCycleUtil(graph, i, vis, stack)){
                return true;
            }
        }
    }
    return false;
}

public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]){
    vis[curr] = true;
    stack[curr] = true;

    for(int i=0; i<graph[curr].size(); i++){
        Edge e = graph[curr].get(i);
        if(stack[e.dest]) {
            return true;
        }
        if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){
            return true;
        }
    }
    stack[curr] = false;
    return false;
}

//Topological Sorting  O(V+E) , O(V)
public static void topSort(ArrayList<Edge> [] graph){
    boolean vis[] = new boolean[graph.length];
    Stack<Integer> s = new Stack<>();

    for(int i=0; i<graph.length; i++){
        if(!vis[i]){
            topSortUtil(graph, i, vis, s);
        }
    }

    while(!s.isEmpty()){
        System.out.println(s.pop() + " ");
    }
}

public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s){
    vis[curr] = true;

    for(int i=0; i<graph[curr].size(); i++){
        Edge e = graph[curr].get(i);
        if(!vis[e.dest]){
            topSortUtil(graph, e.dest, vis, s);
        }
    }
    s.push(curr);
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

   int v = 5;
   ArrayList<Edge>[] graph = new ArrayList[v]; 
   createGraph(graph);
   System.out.println(detectCycle(graph));
   System.out.println(isBipartite(graph));
   System.out.println(IsCycle(graph));
   topSort(graph);
    }
}


