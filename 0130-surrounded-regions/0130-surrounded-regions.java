class Solution {
    public void dfs(int r, int c, boolean vis[][], char board[][], int n, int m){
        vis[r][c] = true;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        for(int i = 0; i < 4; i++){
            int newr = r + dx[i];
            int newc = c + dy[i];
            if(newr >= 0 && newc>=0 && newr < n && newc < m && !vis[newr][newc] && board[newr][newc] == 'O'){
                dfs(newr, newc, vis, board, n, m);
            }
        }
    }
    public  void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        
       for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) dfs(i, 0, vis, board, n, m);
            if (board[i][m - 1] == 'O' && !vis[i][m - 1]) dfs(i, m - 1, vis, board, n, m);
        }

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !vis[0][j]) dfs(0, j, vis, board, n, m);
            if (board[n - 1][j] == 'O' && !vis[n - 1][j]) dfs(n - 1, j, vis, board, n, m);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}