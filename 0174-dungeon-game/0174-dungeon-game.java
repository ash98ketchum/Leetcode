class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int ans = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, ans - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
    // private int helper(int[][] dungeon, int i, int j, int m, int n, int dp[][]) {
    //     if (i == m - 1 && j == n - 1)
    //         return Math.max(1, 1 - dungeon[i][j]);
    //     if(dp[i][j] != -1) return dp[i][j];
    //     int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
    //     if (j + 1 < n)
    //         right = helper(dungeon, i, j + 1, m, n,dp);
    //     if (i + 1 < m)
    //         down = helper(dungeon, i + 1, j, m, n,dp);
    //     int ans = Math.min(right, down);
    //     return dp[i][j] = Math.max(1, ans - dungeon[i][j]);
    // }

