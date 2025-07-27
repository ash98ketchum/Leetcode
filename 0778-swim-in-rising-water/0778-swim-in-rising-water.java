class Solution {
    class tuple{
        int val;
        int r;
        int c;
        tuple(int val, int r, int c){
            this.val = val;
            this.r = r;
            this.c = c;
        }
    }
    class DSU{
        ArrayList<Integer> parent;
        ArrayList<Integer> rank;
        ArrayList<Integer> size;
        
        DSU(int n){
            parent = new ArrayList<>();
            rank = new ArrayList<>();
            size = new ArrayList<>();
            
            for(int i = 0; i < n; i++){
                parent.add(i);
                rank.add(0);
                size.add(1);
                
            }
        }
        
        public int find(int node){
            int temp = node;
            while(temp != parent.get(temp)){
                temp = parent.get(temp);
            }
            parent.set(node, temp);
            return temp;
        }
        
        public void unionByRank(int u, int v){
            int ult_v = find(v);
            int ult_u = find(u);
            
            if(ult_v == ult_u){
                return;
            }
            
            if(rank.get(ult_v) < rank.get(ult_u)){
                parent.set(ult_v, ult_u);
                rank.set(ult_u, rank.get(ult_u) + 1);
            }else{
                parent.set(ult_u, ult_v);
                rank.set(ult_v, rank.get(ult_v) + 1);
            }
        }
    
        public void unionBySize(int u, int v){
            int ult_v = find(v);
            int ult_u = find(u);
            
            if(ult_v == ult_u){
                return;
            }
            
            if(size.get(ult_v) < size.get(ult_u)){
                parent.set(ult_v, ult_u);
                size.set(ult_u, size.get(ult_u) + size.get(ult_v));
            }else{
                parent.set(ult_u, ult_v);
                size.set(ult_v, size.get(ult_u) + size.get(ult_v));
            }
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        ArrayList<tuple> arr = new ArrayList<>();
        boolean vis[] = new boolean[n*n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr.add(new tuple(grid[i][j], i, j));
            }
        }
        Collections.sort(arr, (a,b) -> a.val - b.val);
        int dx[] = {0,-1,0,1};
        int dy[] = {1,0,-1,0};

        DSU dsu = new DSU(n*n + 1);
        for(tuple t : arr){
            int val = t.val;
            int r = t.r;
            int c = t.c;
            int code1 = r * n + c;
            vis[code1] = true;

            for(int i = 0; i < 4; i++){
                int newr = r + dx[i];
                int newc = c + dy[i];
                
                if(newr >= 0 && newr < n && newc >= 0 && newc < n){
                    int code2 = newr * n + newc;
                    if(vis[code2]){
                        dsu.unionByRank(code1, code2);
                    }
                }
            }
            if(dsu.find(0) == dsu.find(((n - 1) * n) + (n - 1))){
                return val;
            }
        }
        return -1;
    }
}