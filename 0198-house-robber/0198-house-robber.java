class Solution {
    public int rob(int[] nums) {
        // state -> dp[i] = maximum amount that can be robbed from house 0 to house i
        // transition -> dp[i] = max(dp[i-1], nums[i] + dp[i-2])
        // base condition -> dp[0] = nums[0], dp[1] = max(nums[0], nums[1]) (if exists)
        // final subproblem -> dp[n-1]

        int n = nums.length;
        if(n == 1) return nums[0];

        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];
    }
}