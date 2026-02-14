class Solution {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        double dp[102][102] = {0.0};
        dp[0][0] = (double)poured;
        
        for(int r = 0; r <= query_row; r++) {
            for(int c = 0; c <= r; c++){
                if(dp[r][c] > 1.0) {
                    double ex = (dp[r][c] - 1.0) / 2.0;
                    dp[r][c] = 1.0;
                    dp[r + 1][c] += ex;
                    dp[r + 1][c + 1] += ex;
                }
            }
        }
        return dp[query_row][query_glass];
    }
};