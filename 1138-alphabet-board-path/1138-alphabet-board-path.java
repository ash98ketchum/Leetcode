class Solution {
    class Pair {
        int r;
        int c;
        String dir;

        Pair(int r, int c, String dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public String alphabetBoardPath(String target) {
        String[] grid = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z####"};
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        char directions[] = {'U','D','R','L'};
        String ans = "";
        
        int sr = 0, sc = 0;
        for(int i = 0; i < target.length(); i++){
            char ch = target.charAt(i);
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(sr,sc, ""));

            boolean vis[][] = new boolean[grid.length + 1][grid[0].length() + 1];
            
            vis[sr][sc] = true;
            while(!q.isEmpty()){
                Pair it = q.poll();
                int r = it.r;
                int c = it.c;
                String d = it.dir;
                
                if(grid[r].charAt(c) == ch){
                    ans += d;
                    sr = r;
                    sc = c;
                    break;
                }
                
                for(int j = 0; j < 4; j++){
                    int newr = r + dx[j];
                    int newc = c + dy[j];
                    String newD = d + directions[j];

                    if(newr >= 0 && newc >= 0 && newr < grid.length && newc < grid[0].length() && !vis[newr][newc] && grid[newr].charAt(newc) != '#'){
                        vis[newr][newc] = true;
                        q.add(new Pair(newr, newc, newD));
                    }
                }
            }
            
            ans += "!";
        }  
        return ans;
    }
}