class Solution {
    class tuple{
        int r;
        int c;
        int dist;
        tuple(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        
        if(grid[0][0] != 0 || grid[n-1][m -1] != 0) return -1;
        
        Queue<tuple> q = new LinkedList<>();
        int dis[][] = new int[n][m];
        for(int it[] : dis){
            Arrays.fill(it, Integer.MAX_VALUE);
        }
        
        q.offer(new tuple(0, 0, 0));
        dis[0][0] = 0;
        
        int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
        int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
        
        while(!q.isEmpty()){
            int r = q.peek().r;
            int c = q.peek().c;
            int dist = q.peek().dist;
            q.poll();
            if(r == n - 1 && c == m - 1){
                return dist + 1;
            }
            for(int i = 0; i < 8; i++){
                int newr = r + dx[i];
                int newc = c + dy[i];
                if(newr >=0 && newc >=0 && newr < n && newc < m && grid[newr][newc] ==0 && dist + 1 < dis[newr][newc]){
                    q.offer(new tuple(newr,newc, dist + 1));
                    dis[newr][newc] = dist + 1;
                }
            }
        }
        return -1;
    }
}