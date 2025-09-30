class Solution {
    public class tuple{
        int r;
        int c;
        public tuple(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public void dfs(int r, int c, int n, int m, char grid[][], boolean visited[][]){
        visited[r][c] = true;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0,-1,0,1};
        for(int i = 0; i < 4; i++){
            int newr = r + dx[i];
            int newc = c + dy[i];
            if(newr >= 0 && newc >= 0 && newr< n && newc < m && grid[newr][newc] == '1' && !visited[newr][newc]){
                dfs(newr,newc, n,m, grid, visited);
            }
        }

    }
    public void bfs(int r, int c, int n, int m, char grid[][], boolean visited[][]){
        Queue<tuple> q = new LinkedList<>();
        q.offer(new tuple(r,c));
        visited[r][c] = true;

        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0,-1,0,1};

        while(!q.isEmpty()){
            r = q.peek().r;
            c = q.peek().c;
            q.poll();
            for(int i = 0; i < 4; i++){
                int newr = r + dx[i];
                int newc = c+ dy[i];
                if(newr >= 0 && newc >= 0 && newr< n && newc < m && grid[newr][newc] == '1' && !visited[newr][newc]){
                    visited[newr][newc] = true;
                    q.offer(new tuple(newr,newc));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][]= new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    visited[i][j] = true;
                    
                    bfs(i,j,n,m,grid,visited);
                    cnt++;
                    
                }
            }
        }
        return cnt;
    }
}