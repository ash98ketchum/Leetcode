class Solution {
public:
    int maxPathScore(vector<vector<int>>& grid, int k) {
        int n = grid.size(), m = grid[0].size();
        auto cost  = [&](int v){ return v == 0 ? 0 : 1; };

        vector<vector<vector<int>>> dp(n, vector<vector<int>>(m, vector<int>(k+1, -1)));
        
        int sc = grid[0][0];
        int cs = cost(grid[0][0]);
        if (cs <= k) dp[0][0][cs] = sc;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int val = grid[i][j];
                int cellS = val;
                int cellC = cost(val);

                for (int c = 0; c <= k; ++c) {
                    if (dp[i][j][c] == -1) continue;
                    if (j + 1 < m) {
                        int nc = c + cost(grid[i][j + 1]);
                        if (nc <= k)
                            dp[i][j + 1][nc] = max(dp[i][j + 1][nc],
                                                    dp[i][j][c] + (grid[i][j + 1]));
                    }
                    if (i + 1 < n) {
                        int nc = c + cost(grid[i + 1][j]);
                        if (nc <= k)
                            dp[i + 1][j][nc] = max(dp[i + 1][j][nc],
                                                    dp[i][j][c] + (grid[i + 1][j]));
                    }
                }
            }
        }

        int ans = -1;
        for (int c = 0; c <= k; ++c)
            ans = max(ans, dp[n - 1][m - 1][c]);
        return ans;
    }
};
