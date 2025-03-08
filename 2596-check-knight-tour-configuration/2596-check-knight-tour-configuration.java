class Solution {
    //knight movement 
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static boolean myrec(int grid[][], boolean visited[][], int r, int c, int moves, int n){
        if (moves == n*n){
            return true;
        }
        if (r < 0 || c < 0 || r >= n || c >= n || visited[r][c] || grid[r][c] != moves) return false;
        visited[r][c] = true;
        if(myrec(grid, visited, r - 2, c + 1, moves + 1, n) ||
        myrec(grid, visited, r - 1, c + 2, moves + 1, n) ||
        myrec(grid, visited, r + 2, c + 1, moves + 1, n) ||
        myrec(grid, visited, r +1, c + 2, moves + 1, n) ||
        myrec(grid, visited, r + 2, c - 1, moves + 1, n) ||
        myrec(grid, visited, r +1, c - 2, moves + 1, n) || 
        myrec(grid, visited, r - 1, c - 2, moves + 1, n) ||
        myrec(grid, visited, r - 2, c - 1, moves + 1, n)
        ){
            return true;
        }
        return false;

    }
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        boolean visited[][] = new boolean[n][n];
        if (myrec(grid,visited,0,0,0,n)){
            return true;
        }
        return false;
    }
}