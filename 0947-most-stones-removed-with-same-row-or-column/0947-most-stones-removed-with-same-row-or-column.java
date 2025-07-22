class Solution {
    class DSU{
        ArrayList<Integer> parent, rank;
        DSU(int n){
            parent = new ArrayList<>(n);
            rank = new ArrayList<>(n);
            for(int i = 0; i < n; i++){
                parent.add(i);
                rank.add(0);
            }
        }
        public int find(int u){
            int temp = u;
            while(parent.get(u) != u){
                u = parent.get(u);
            }
            parent.set(temp, u);
            return u;
        }
        public void union(int u, int v){
            int ULT_u = find(u);
            int ULT_v = find(v);

            if(ULT_u == ULT_v){
                return;
            }

            if(rank.get(ULT_u) > rank.get(ULT_v)){
                rank.set(ULT_u, rank.get(ULT_u) + 1);
                parent.set(ULT_v, ULT_u);
            }
            else if(rank.get(ULT_v) > rank.get(ULT_u)){
                rank.set(ULT_v, rank.get(ULT_v) + 1);
                parent.set(ULT_u, ULT_v);
            }
            else{
                rank.set(ULT_u, rank.get(ULT_u) + 1);
                parent.set(ULT_v, ULT_u);
            }

        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU(n);
        for(int i = 0; i<n; i++){
            for(int j =i+1; j < n; j++){
                int pu = dsu.find(i);
                int pv = dsu.find(j);
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    dsu.union(i,j);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += dsu.rank.get(i);
        }
        return ans;
        
    }
}