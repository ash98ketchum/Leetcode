class Solution {
    class tuple{
        int r;
        int c;
        int dist;
        tuple(int r,int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};

        int dist[][] = new int[n][m];
        for(int it[] : dist){
            Arrays.fill(it, Integer.MAX_VALUE);
        }
        PriorityQueue<tuple> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.dist, b.dist));
        dist[0][0] = 0;
        pq.offer(new tuple(0,0,0));

        while(!pq.isEmpty()){
            int r = pq.peek().r;
            int c = pq.peek().c;
            int dis = pq.peek().dist;
            pq.poll();
            if(r == n - 1 && c == m -1){
                return dis;
            }
            for(int i = 0; i < 4; i++){
                int newr = r + dx[i];
                int newc = c + dy[i];
                if(newr >=0 && newr < n && newc >=0 && newc < m){
                    int neweffort = Math.abs(heights[newr][newc] - heights[r][c]);
                    neweffort = Math.max(neweffort, dis);
                    if(neweffort < dist[newr][newc]){
                        dist[newr][newc] = neweffort;
                        pq.offer(new tuple(newr, newc, neweffort));
                    }
                    
                }
            }
        }
        return 0;
    }
}