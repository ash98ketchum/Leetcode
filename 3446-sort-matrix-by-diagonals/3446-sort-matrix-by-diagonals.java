class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        for(int i = 0; i < n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            int r = i;
            int c = 0;
            while(r < n && c < m){
                temp.add(grid[r][c]);
                r++;
                c++;
            }
            Collections.sort(temp);
            Collections.reverse(temp);
            r = i;
            c = 0;
            int idx = 0;
            while(r < n && c < m){
                grid[r][c] = temp.get(idx);
                r++;
                c++;
                idx++;
            }
        }
        for(int j = 1; j < m; j++){
            ArrayList<Integer> temp = new ArrayList<>();
            int r = 0;
            int c = j;
            while(r < n && c < m){
                temp.add(grid[r][c]);
                r++;
                c++;
            }
            Collections.sort(temp);
            r = 0;
            c = j;
            int idx = 0;
            while(r < n && c < m){
                grid[r][c] = temp.get(idx);
                r++;
                c++;
                idx++;
            }
        }
        return grid;
    }
}