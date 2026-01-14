class Solution {
public:
    int dp[10][2][10];
    int myrec(string &s, int idx, int bound, int cnt){
        if(idx == s.size()) return cnt;
        if(dp[idx][bound][cnt] != -1) return dp[idx][bound][cnt];

        int limit = (bound == 1 ? s[idx] - '0' : 9);
        int ans = 0;
        for(int i = 0; i <= limit; i++){
            int updcnt = cnt + (i == 1 ? 1 : 0);
            ans += myrec(s, idx + 1, bound & (i == s[idx] - '0'), updcnt);
        }
        return ans;
    }
    int countDigitOne(int n) {
        string s = to_string(n);
        memset(dp, -1, sizeof(dp));
        return myrec(s, 0, 1, 0);
    }
};