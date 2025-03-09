class Solution {
    public int climbStairs(int n) {
        //state - > dp[k] = no of ways to climb k stairs
        //transition -> dp[k] = dp[k-1] + dp[k-2]
        //base case => d[0] = 1
        //final problem => dp[n];
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];


    }
}