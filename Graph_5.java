import java.util.*;
public class Graph_5{
//Disjoint set    
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];
    
    public static void init(){
        for(int i=0; i<n; i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if(x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]); /*Path Compression =  Here we changed the line return find(par[x]) to return par[x] = find(par[x])*/
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);
        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] < rank[parB]){
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

//Krushkal's Algorithm - O(V+E logE)
   static class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int w){
        this.src = s;
        this.dest = d;
        this.wt = w;
    }

    @Override
    public int compareTo(Edge e2){
        return this.wt - e2.wt;
    }
}

static void createGraph(ArrayList<Edge> edges){
    //edges
    edges.add(new Edge(0, 1, 10));
    edges.add(new Edge(0, 2, 15));
    edges.add(new Edge(0, 3, 30));
    edges.add(new Edge(1, 3, 40));
    edges.add(new Edge(2, 3, 50));
}

static int a = 4;
static int Par[] = new int[a];
static int Rank[] = new int[a];
public static void Init(){
    for(int i=0; i<n; i++){
        Par[i] = i;
    }
}

public static void krushkalsMST(ArrayList<Edge> edges, int V){
    Init();
    Collections.sort(edges);
    int mstCost = 0;
    int count = 0;

    for(int i =0; count<V-i; i++){
     Edge e = edges.get(i);
     //src, dest, wt

     int ParA = find(e.src);
     int ParB = find(e.dest);
     if(ParA != ParB){
        union(e.src, e.dest);
        mstCost += e.wt;
        count++;
        }
    }
    System.out.println(mstCost);
}


//Flood Fill algo - O(m*n)
public void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol){
    if(sr < 0 || sc < 0 || sr>= image.length || sc > image[0].length 
        || vis[sr][sc] || image[sr][sc] != orgCol){
            return;
        }
    image[sr][sc] = color;
    //left
    helper(image, sr, sc-1, color, vis, orgCol);
    //right
    helper(image, sr, sc+1, color, vis, orgCol);
    //up
    helper(image, sr-1, sc, color, vis, orgCol);
    //down
    helper(image, sr+1, sc, color, vis, orgCol);

}
public int[][] floodfill(int[][] image, int sr, int sc, int color){
    boolean vis[][] = new boolean[image.length][image[0].length];
    helper(image, sr, sc, color, vis, image[sr][sc]);
    return image;
}

//Cheapest Flights
public static void CreateGraph(int flights[][], ArrayList<Edge> graph[]){
    for(int i = 0; i<graph.length; i++){
        graph[i] = new ArrayList<>();
    }

    for(int i=0; i<flights.length; i++){
        int src = flights[i][0];
        int dest = flights[i][1];
        int wt = flights[i][2];

        Edge e = new Edge(src, dest, wt);
        graph[src].add(e);
    }
} 

static class Info {
    int v;
    int cost;
    int stops;

    public Info(int v, int c, int s){
        this.v = v;
        this.cost = c;
        this.stops = s;

    }
}
public static int cheapestFlight(int n, int flights[][], int src, int dest, int k){
    ArrayList<Edge> graph[] = new ArrayList[n];
    CreateGraph(flights, graph);

    int dist[] = new int[n];
    for(int i=0; i<n; i++){
        if(i != src){
            dist[i] = Integer.MAX_VALUE;
        }
    }

    Queue<Info> q = new LinkedList<>();
    q.add(new Info(src, 0, 0));

    while(!q.isEmpty()) {
        Info curr = q.remove();
        if(curr.stops > k) {
            break;
        }

        for(int i =0; i<graph[curr.v].size(); i++){
            Edge e = graph[curr.v].get(i);
            int u = e.src;
            int v = e.dest;
            int wt = e.wt;

            if(dist[u] != Integer.MAX_VALUE &&dist[u] + wt < dist[v] && curr.stops <= k){
                dist[v] = dist[u] + wt;
                q.add(new Info(v, dist[v], curr.stops+1));
            }
        }
    }

    //dist[dest]
    if(dist[dest] == Integer.MAX_VALUE) {
        return -1;
    } else {
        return dist[dest];
    }
}

//Connecting cities
static class edge implements Comparable<edge> {
    int dest;
    int cost;

    
    public edge(int d, int c){
        this.dest = d;
        this.cost = c;

    }
    @Override
    public int compareTo(edge e2) {
        return this.cost - e2.cost; //ascending
    }
}

public static int connectCities(int cities[][]){
    PriorityQueue<edge> pq = new PriorityQueue<>();
    boolean vis[] = new boolean[cities.length];

    pq.add(new edge(0, 0));
    int finalCost = 0;

    while(!pq.isEmpty()){
        edge curr = pq.remove();
        if(!vis[curr.dest]){
           vis[curr.dest] = true;
           finalCost += curr.cost;

           for(int i=0; i<cities[curr.dest].length; i++){
            if(cities[curr.dest][i] != 0){
                pq.add(new edge(i, cities[curr.dest][i]));
            }
           }
        }
    }
    return finalCost;
}
public static void main(String args[]){
    init();
    union(1, 3);
    System.out.println(find(3));
    union(2, 4);
    union(3, 6);
    union(1, 4);
    System.out.println(find(3));
    System.out.println(find(4));
    union(1,5);
    System.out.println(find(5));

//Krushkal's Algo
int V =4;
ArrayList<Edge> edges = new ArrayList<>();
createGraph(edges);
krushkalsMST(edges, V);

int n =4;
int flights[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
int src =0 , dst = 3, k = 1;

ArrayList<Edge> graph[] = new ArrayList[n]; 
int cities[][] = {{0, 1, 2, 3, 4},
                  {1, 0, 5, 0, 7},
                  {2, 5, 0, 6, 0},
                  {3, 0, 6, 0 ,0},
                  {4, 7, 0, 0, 0}};
    }
}

