class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] cand1 = null, cand2 = null;
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (parent[v] == 0) {
                parent[v] = u;
            } 
            else{
                cand1 = new int[]{parent[v], v};
                cand2 = new int[]{u, v};
                e[1] = 0;
            }
        }
        int[] uf = new int[n + 1];
        for (int i = 1; i <= n; i++) uf[i] = i;

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (v == 0) continue;

            int pu = find(uf, u);
            if (pu == v) {
                if (cand1 == null) return e;
                return cand1;
            }
            uf[v] = pu;
        }

        return cand2;
    }

    private int find(int[] uf, int x) {
        return uf[x] == x ? x : (uf[x] = find(uf, uf[x]));
    }
}
