
class Solution {
    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        dist[0] = 0;
        if (disappear[0] == 0) {
            Arrays.fill(dist, -1);
            return dist;
        }

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            int node = cur.node;
            int time = cur.dist;
            if (time > dist[node]) continue;
            for (Pair next : adj.get(node)) {

                int nextNode = next.node;
                int newTime = time + next.dist;

                if (newTime >= disappear[nextNode]) continue;
                if (newTime < dist[nextNode]) {

                    dist[nextNode] = newTime;
                    pq.add(new Pair(nextNode, newTime));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
