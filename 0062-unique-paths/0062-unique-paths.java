class Solution {
    public int uniquePaths(int m, int n) {
        //state -> i and j are two states defining number of rows and number of column dp[i][j] will define total number of ways to reach point (i,j)

        //transition -> dp[i][j] = dp[i-1][j] + dp[i][j-1];

        //base case -> dp[0][0] = 1;

        //final subproblem -> dp[m-1][n-1];

        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i > 0) dp[i][j] += dp[i-1][j];
                if(j > 0) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}