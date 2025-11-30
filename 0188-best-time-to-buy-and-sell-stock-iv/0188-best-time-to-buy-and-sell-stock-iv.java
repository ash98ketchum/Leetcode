class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        if (k >= n / 2) {
            int ans = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1];
            }
            return ans;
        }
        int[][][] dp = new int[n][k + 1][2];

        for (int t = 0; t <= k; t++) {
            dp[0][t][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= k; t++) {
                dp[i][t][0] = dp[i - 1][t][0];
                if (t > 0) dp[i][t][0] = Math.max(dp[i][t][0], dp[i - 1][t - 1][1] + prices[i]);

                dp[i][t][1] = Math.max(dp[i - 1][t][1], dp[i - 1][t][0] - prices[i]);
            }
        }

        int ans = 0;
        for (int t = 0; t <= k; t++) ans = Math.max(ans, dp[n - 1][t][0]);
        return ans;
    }
}