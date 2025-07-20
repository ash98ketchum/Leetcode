class Solution {
    class pair{
        int f;
        int s;
        pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int it[] : times){
            int u = it[0];
            int v = it[1];
            int w = it[2];
            adj.get(u).add(new pair(v,w));
        }
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.s,b.s));
        dist[k] = 0;
        pq.offer(new pair(k, 0));
        while(!pq.isEmpty()){
            int node = pq.peek().f;
            int dis = pq.peek().s;
            pq.poll();
            for(pair it : adj.get(node)){
                int node2 = it.f;
                int dis2 = it.s;
                if(dis + dis2 < dist[node2]){
                    dist[node2] = dis + dis2;
                    pq.offer(new pair(node2, dis + dis2));
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) 
                return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}