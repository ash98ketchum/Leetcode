class Solution {
    public static void dfs(boolean vis[][], int r, int c, int n, int m, int grid[][]){
        vis[r][c] = true;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, -1, 0, 1};
        
        for(int i = 0; i < 4; i++){
            int newr = r + dx[i];
            int newc = c + dy[i];
            if(newr >=0 && newc >= 0 && newr < n && newc < m && !vis[newr][newc] && grid[newr][newc] == 1){
                dfs(vis, newr, newc, n, m, grid);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        int cnt = 0;
        
        for(int i = 0; i < n; i++) for(int j = 0; j < m ; j++) if(grid[i][j] == 1) cnt++;
        
        for(int i = 0; i < n; i++){
            if(!vis[i][0] && grid[i][0] == 1){
                dfs(vis, i, 0, n, m, grid);
                
            }
            if(!vis[i][m-1] && grid[i][m-1] == 1){
                dfs(vis, i, m-1, n, m,grid);
                
            }
        }
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 1 && !vis[0][j]){
                dfs(vis, 0, j, n, m, grid);
                
            }
            if(grid[n - 1][j] == 1 && !vis[n - 1][j]){
                dfs(vis, n - 1, j, n, m, grid);
                
            }
        }
        
        int boundaryones = 0;
        for(boolean b[] : vis){
            for(boolean it : b){
                if(it) boundaryones++;
            }
        }
        
        
        return cnt - boundaryones;
    }
}