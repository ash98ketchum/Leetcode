class Solution {
    private int dfs(int grid[][], int n, int m, int r, int c, int tr, int tc, boolean vis[][], int len){
        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == -1 || vis[r][c]) return 0;
        if(r == tr && c == tc && len == 0){
            return 1;
        }
        

        int cnt = 0;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        vis[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];
            cnt += dfs(grid, n, m, nr, nc, tr, tc, vis, len - 1);
        }
        vis[r][c] = false;
        return cnt;
    }
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int r = -1, c = -1, tr = -1, tc = -1;
        int total = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    r = i;
                    c = j;
                }
                if(grid[i][j] == 2){
                    tr = i;
                    tc = j;
                }
                if(grid[i][j] != -1){
                    total++;
                }
            }
        }

        return dfs(grid, n, m, r, c, tr, tc, vis, total - 1);
    }
}