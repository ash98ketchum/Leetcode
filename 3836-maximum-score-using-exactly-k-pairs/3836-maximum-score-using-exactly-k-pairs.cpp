using ll = long long;

class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size();
        int m = nums2.size();
        ll INF = 1e18;
        vector<vector<vector<ll>>> dp(n + 1, vector<vector<ll>>(m + 1, vector<ll>(k + 1, -INF)));
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j][0] = 0;
            }
        }

        for(int c = 1; c <= k; c++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    ll res = max(dp[i-1][j][c], dp[i][j-1][c]);
                    if(dp[i-1][j-1][c-1] != -INF){
                        res = max(res, (ll)nums1[i-1] * nums2[j-1] + dp[i-1][j-1][c-1]);
                    }
                    
                    dp[i][j][c] = res;
                }
            }
        }

        return dp[n][m][k];
    }
};