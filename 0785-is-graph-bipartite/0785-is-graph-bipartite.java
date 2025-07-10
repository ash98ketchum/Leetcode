class Solution {
    // ans = math.abs(ans - 1) -> 1 se 0 ban jaega ya 0 se 1 
    public boolean dfs(int node, int c, boolean vis[], int[][] adj, int color[]){
        vis[node] = true;
        color[node] = c;
        for(int it : adj[node]){
            int newcolor = Math.abs(c - 1);
            if(!vis[it]){
                if(dfs(it, newcolor, vis, adj, color) == false){
                    return false;
                }
            }
            else if(color[node] == color[it]){
                return false;
            }
            // if (!vis[it]) {
            //     if (!dfs(it, newColor, vis, adj, color)) {
            //         return false;
            //     }
            // } else if (color[it] == color[node]) {
            //     // Conflict in coloring
            //     return false;
            // }
        }
        return true;
    }
    public boolean isBipartite(int[][] adj) {
    
    // [[1,2,3],[0,2],[0,1,3],[0,2]]
    
    int n = adj.length;
    int color[] = new int[n];
    boolean vis[] = new boolean[n];
    for(int node = 0; node < n; node++){
        if(!vis[node]){
            if(dfs(node, 0, vis, adj, color) == false){
                return false;
            }
        }
    }
    return true;
    }
}