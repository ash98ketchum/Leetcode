class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int r = 1; r < n; r++){
            for(int c = 0; c < n; c++){
                int down = dp[r-1][c];
                int leftdiag = Integer.MAX_VALUE;
                if(c > 0){
                    leftdiag = dp[r-1][c-1];
                }
                int rightdiag = Integer.MAX_VALUE;
                if(c < n-1){
                    rightdiag = dp[r-1][c+1];
                }
                dp[r][c] = matrix[r][c] + Math.min(down, Math.min(leftdiag,rightdiag));
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }
}