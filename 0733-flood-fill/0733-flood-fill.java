class Solution {
    public class tuple{
        int r;
        int c;
        public tuple(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int original = image[sr][sc];
        if (original == color) 
            return image;
        Queue<tuple> q = new LinkedList<>();
        image[sr][sc] = color;
        q.offer(new tuple(sr,sc));
        int dx[] = {0,1,0,-1};
        int dy[] = {-1,0,1,0};
        while(!q.isEmpty()){
            int r = q.peek().r;
            int c = q.peek().c;
            q.poll();
            for(int i = 0; i < 4; i++){
                int newr = r + dx[i];
                int newc = c + dy[i];
                if(newr>=0 && newc >= 0 && newr < n && newc < m && image[newr][newc] == original){
                    image[newr][newc] = color;
                    q.offer(new tuple(newr, newc));
                }
            }
        }
        return image;
    }
}