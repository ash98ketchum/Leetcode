class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long MOD = 1_000_000_000 + 7;
        long dp[] = new long[n + 1];
        dp[1]= 1;
        long val = 0;
        for(int i = 2; i <=n; i++){
            if(i - delay > 0){
                val = (val + dp[i - delay]) % MOD;
            }
            if(i - forget > 0){
                val = (val - dp[i - forget] + MOD) % MOD;
            }
            dp[i] = val;
        }
        long ans = 0;
        for(int i = n - forget + 1; i <= n; i++){
            ans = (ans + dp[i]) % MOD;
        }
        return (int)ans;
    }
}