class Solution {
    public void dfs(int node, int adj[][] , boolean visited[], int n){
        visited[node] = true;
        for(int i = 0; i < n; i++){
            if(adj[node][i] != 0 && !visited[i]){
                dfs(i, adj, visited, n);
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int cnt = 0;
        boolean visited[] = new boolean[n + 1];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, adj, visited, n);
                cnt++;
            }
        }
        return cnt;
    }
}