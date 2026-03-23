class Solution {
public:
    int maxProductPath(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int MOD = 1e9 + 7;

        vector<vector<long long>> dp1(n, vector<long long>(m));
        vector<vector<long long>> dp2(n, vector<long long>(m));

        dp1[0][0] = dp2[0][0] = grid[0][0];
        for(int i = 1; i < n; i++){
            dp1[i][0] = dp2[i][0] = dp1[i-1][0] * grid[i][0];
        }
        for(int j = 1; j < m; j++){
            dp1[0][j] = dp2[0][j] = dp1[0][j-1] * grid[0][j];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                long long val = grid[i][j];

                long long a = dp1[i-1][j] * val;
                long long b = dp2[i-1][j] * val;
                long long c = dp1[i][j-1] * val;
                long long d = dp2[i][j-1] * val;

                dp1[i][j] = max({a, b, c, d});
                dp2[i][j] = min({a, b, c, d});
            }
        }

        long long ans = dp1[n-1][m-1];

        if(ans < 0) return -1;
        return ans % MOD;
    }
};