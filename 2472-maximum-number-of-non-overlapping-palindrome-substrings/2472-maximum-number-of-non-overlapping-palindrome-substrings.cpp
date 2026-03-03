class Solution {
public:
    int maxPalindromes(string s, int k) {
        int n = s.size();
        vector<vector<bool>> isPal(n, vector<bool>(n, false));
        
        for(int center = 0; center < n; center++) {
            int l = center, r = center;
            while(l >= 0 && r < n && s[l] == s[r]) {
                isPal[l][r] = true;
                l--; r++;
            }
            
            l = center;
            r = center + 1;
            while(l >= 0 && r < n && s[l] == s[r]) {
                isPal[l][r] = true;
                l--; r++;
            }
        }
        
        vector<int> dp(n + 1, 0);
        
        for(int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];
            for(int j = i + k - 1; j < n; j++) {
                if(isPal[i][j]) {
                    dp[i] = max(dp[i], 1 + dp[j + 1]);
                }
            }
        }
        
        return dp[0];
    }
};