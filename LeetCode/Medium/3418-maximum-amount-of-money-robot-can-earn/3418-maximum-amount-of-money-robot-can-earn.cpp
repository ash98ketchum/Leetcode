class Solution {
public:
    int maximumAmount(vector<vector<int>>& coins) {
        int n = coins.size();
        int m = coins[0].size();

        vector<vector<vector<int>>> dp(n, vector<vector<int>>(m, vector<int>(3, -1e9)));

        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;
            dp[0][0][2] = 0;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0) continue;

                for(int k = 0; k <= 2; k++){

                    int best = -1e9;
                    if(i > 0){
                        best = max(best, dp[i-1][j][k] + coins[i][j]);
                        if(coins[i][j] < 0 && k > 0)
                            best = max(best, dp[i-1][j][k-1]);
                    }
                    if(j > 0){
                        best = max(best, dp[i][j-1][k] + coins[i][j]);
                        if(coins[i][j] < 0 && k > 0)
                            best = max(best, dp[i][j-1][k-1]);
                    }

                    dp[i][j][k] = best;
                }
            }
        }

        return max({dp[n-1][m-1][0], dp[n-1][m-1][1], dp[n-1][m-1][2]});
    }
};