class Solution {
    public int minPathSum(int[][] grid) {
        //state -> minimum value of path sum required to reach the index (i,j)
        //transition -> dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);

        //base case -> dp[0][0] = grid[0][0]
        //final subproblem -> dp[n-1][m-1];

        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];

        dp[0][0] = grid[0][0];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i > 0 && j > 0){
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
                else if(i > 0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }
                else if(j > 0){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}