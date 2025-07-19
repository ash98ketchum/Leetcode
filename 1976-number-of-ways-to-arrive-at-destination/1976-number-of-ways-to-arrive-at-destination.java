class Solution {
    class pair {
        long f;
        int s;

        pair(long f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9 + 7);
        List<List<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adj.get(u).add(new pair(w, v));
            adj.get(v).add(new pair(w, u));
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.f, b.f));
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new pair(0, 0));

        while (!pq.isEmpty()) {
            pair curr = pq.poll();
            long dis = curr.f;
            int node = curr.s;

            if (dis > dist[node]) continue;

            for (pair neighbor : adj.get(node)) {
                long wt = neighbor.f;
                int adjNode = neighbor.s;

                if (dis + wt < dist[adjNode]) {
                    dist[adjNode] = dis + wt;
                    ways[adjNode] = ways[node];
                    pq.offer(new pair(dis + wt, adjNode));
                } else if (dis + wt == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}
