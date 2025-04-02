class Solution {
    // public static int myrec(int idx, int cost[], int dp[]){
    //     if(idx == 0 || idx == 1) return cost[idx];
    //     if(dp[idx] != -1) return dp[idx];
    //     return dp[idx] = cost[idx] + Math.min(myrec(idx - 1, cost, dp), myrec(idx - 2, cost, dp));
    // }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i< n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}