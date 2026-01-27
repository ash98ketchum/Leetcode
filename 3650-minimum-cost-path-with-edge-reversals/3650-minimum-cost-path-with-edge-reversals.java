class Tuple{
    int node;
    int weight;
    Tuple(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Pair{
    int node;
    long dist;
    Pair(int node, long dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int minCost(int n, int[][] edges) {
        ArrayList<ArrayList<Tuple>> adj = new ArrayList<>();
        ArrayList<ArrayList<Tuple>> rev = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        for(int e[] : edges){
            int u = e[0], v= e[1], w= e[2];
            adj.get(u).add(new Tuple(v,w));
            rev.get(v).add(new Tuple(u,w));
        }

        long maxx = Long.MAX_VALUE/4;
        long[] dist = new long[n];
        Arrays.fill(dist, maxx);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Long.compare(a.dist,b.dist));
        dist[0] = 0;
        pq.add(new Pair(0,0));
        boolean vis[] = new boolean[n];

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            long d = p.dist;
            if(vis[node]){
                continue;
            }
            if(node == n - 1){
                break;
            }
            for(Tuple it : adj.get(node)){
                int v = it.node;
                long newd = d + it.weight;
                if(newd < dist[v]){
                    dist[v] = newd;
                    pq.add(new Pair(v, newd));
                }
            }
            for(Tuple it : rev.get(node)){
                int v = it.node;
                long newd = d + 2 * it.weight;
                if(newd < dist[v]){
                    dist[v] = newd;
                    pq.add(new Pair(v, newd));
                }
            }
        }
        return dist[n - 1] >= maxx/2 ? -1 : (int)dist[n -1];
        
        
    }
}