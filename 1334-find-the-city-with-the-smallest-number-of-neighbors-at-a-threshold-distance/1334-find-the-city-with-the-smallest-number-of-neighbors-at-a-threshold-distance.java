class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int adj[][] = new int[n][n];
        for(int it[]: adj){
            Arrays.fill(it, (int)1e9);
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj[u][v] = w;
            adj[v][u] = w;
        }
        for(int i = 0; i < n; i++){
            adj[i][i] = 0;
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i< n; i++){
                for(int j = 0; j < n; j++){
                    if(adj[i][k] == (int)1e9 || adj[k][j] == (int)1e9){
                        continue;
                    }
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        int glob = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(adj[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(glob >= cnt){
                glob = cnt;
                ans = i;
            }
        }
        return ans;
    }
}