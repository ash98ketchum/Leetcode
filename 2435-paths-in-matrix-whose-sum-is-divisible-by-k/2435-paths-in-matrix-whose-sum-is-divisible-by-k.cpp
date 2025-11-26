class Solution {
public:
    const long long MOD = 1e9 + 7;

    int numberOfPaths(vector<vector<int>>& grid, int k) {
        int n = grid.size();
        int m = grid[0].size();

        vector<vector<vector<long long>>> dp(n, vector<vector<long long>>(m, vector<long long>(k, 0)));
        dp[0][0][ grid[0][0] % k ] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int sum = 0; sum < k; sum++) {

                    int cur = grid[i][j] % k;
                    int prev = (sum - cur + k) % k;

                    if (i > 0)
                        dp[i][j][sum] = (dp[i][j][sum] + dp[i-1][j][prev]) % MOD;

                    if (j > 0)
                        dp[i][j][sum] = (dp[i][j][sum] + dp[i][j-1][prev]) % MOD;
                }
            }
        }

        return dp[n-1][m-1][0];
    }
};
