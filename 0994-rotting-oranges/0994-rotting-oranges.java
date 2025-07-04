class Solution {
    public class Tuple{
        int r;
        int c;
        int t;
        Tuple(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Tuple> q = new LinkedList<>();
        int totalfresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new Tuple(i,j,0));
                    visited[i][j] = true;
                }
                
                if(grid[i][j] == 1){
                    totalfresh++;
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            int r = q.peek().r;
            int c = q.peek().c;
            int t = q.peek().t;
            ans = Math.max(ans, t);
            q.poll();
            
            if(r + 1 >=0 && c >=0 && r+1 < m && c < n && !visited[r+1][c] && grid[r+1][c] == 1){
                q.offer(new Tuple(r+1,c,t+1));
                visited[r+1][c] = true;
                totalfresh--;
            }
            if(r >=0 && c+1 >=0  && r < m && c+1 < n && !visited[r][c+1] && grid[r][c+1] == 1){
                q.offer(new Tuple(r,c+1,t+1));
                visited[r][c + 1] = true;

                totalfresh--;
            }
            if(r - 1 >=0 && c >=0  && r-1 < m && c < n && !visited[r-1][c] && grid[r-1][c] == 1){
                q.offer(new Tuple(r-1,c,t+1));
                visited[r-1][c] = true;
                totalfresh--;
            }
            if(r >=0 && c-1 >=0  && r < m && c-1 < n && !visited[r][c-1] && grid[r][c-1] == 1){
                q.offer(new Tuple(r,c-1,t+1));
                visited[r][c-1] = true;
                totalfresh--;
            }
        }
        
        if(totalfresh > 0){
            return -1;
        }
        return ans;
        
    }
}