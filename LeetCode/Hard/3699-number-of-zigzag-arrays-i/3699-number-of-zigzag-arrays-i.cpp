using ll = long long;
class Solution {
public:
    const int MOD = 1e9 + 7;
    int dp[2005][2005][2];
    int zigZagArrays(int n, int l, int r) {
        ll mx = r - l + 1;
        for(int j = 1; j <= mx; j++){
            dp[1][j][0] = 1;
            dp[1][j][1] = 1;   
        }
        
        
        for(int i= 2; i <= n; i++){
            int pref = 0;
            for(int j = 1; j <= mx; j++){
                dp[i][j][0] = pref;
                pref = (pref + dp[i-1][j][1]) % MOD;
            }
            int suff = 0;
            for(int j = mx; j >= 1; j--){
                dp[i][j][1] = suff;
                suff = (suff + dp[i-1][j][0]) % MOD;
            }
        }
        int tot = 0;
        for(int j = 1; j <= mx; j++){
            tot = (tot + dp[n][j][0]) % MOD;
            tot = (tot + dp[n][j][1]) % MOD;
        }
        return tot;
    }
};