import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (events[j][1] < events[i][0]) {
                    prev[i] = j;
                    break;
                }
            }
        }
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i > 0) dp[i][j] = dp[i - 1][j];
                int take = events[i][2];
                if (prev[i] != -1) {
                    take += dp[prev[i]][j - 1];
                }
                else if (j - 1 == 0) {
                    take = events[i][2];
                }

                dp[i][j] = Math.max(dp[i][j], take);
            }
        }

        return dp[n - 1][k];
    }
}
