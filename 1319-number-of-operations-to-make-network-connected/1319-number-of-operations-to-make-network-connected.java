class Solution {
    public static class DSU {
        ArrayList<Integer> rank, parent, size;

        DSU(int n) {
            rank = new ArrayList<>();
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);  // ✅ initialize size as 1
            }
        }

        public int find(int node) {
            if (parent.get(node) != node) {
                parent.set(node, find(parent.get(node))); // path compression
            }
            return parent.get(node);
        }

        public void unionfindrank(int u, int v) {
            int Ult_u = find(u);
            int Ult_v = find(v);
            if (Ult_u == Ult_v) return;

            if (rank.get(Ult_u) > rank.get(Ult_v)) {
                parent.set(Ult_v, Ult_u);
            } else if (rank.get(Ult_u) < rank.get(Ult_v)) {
                parent.set(Ult_u, Ult_v);
            } else {
                parent.set(Ult_u, Ult_v);
                rank.set(Ult_v, rank.get(Ult_v) + 1);
            }
        }

        public void unionfindsize(int u, int v) {
            int Ult_u = find(u);
            int Ult_v = find(v);
            if (Ult_u == Ult_v) return;

            if (size.get(Ult_u) > size.get(Ult_v)) {
                parent.set(Ult_v, Ult_u);
                size.set(Ult_u, size.get(Ult_u) + size.get(Ult_v));
            } else {
                parent.set(Ult_u, Ult_v);
                size.set(Ult_v, size.get(Ult_v) + size.get(Ult_u));
            }
        }

        // ✅ This method is added to allow calling just unionfind()
        public void unionfind(int u, int v) {
            unionfindrank(u, v);  // you can swap to unionfindsize(u, v) here if needed
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n );
        int extra = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];

            if(dsu.find(u) != dsu.find(v)){
                dsu.unionfindsize(u, v);
            }else{
                extra++;
            }
        }
        for(int i = 0; i < n; i++){
            set.add(dsu.find(i));
        }
        return (set.size() - 1) <= extra ? (set.size() -1) : -1;
    }
}