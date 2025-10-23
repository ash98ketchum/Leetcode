class Solution {
public:
    int myrec(string &s, string &t, int i, int j, vector<vector<int>> &dp) {
        if(j == t.size()) return 1;
        if(i == s.size()) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int x = 0, y = 0;
        if(s[i] == t[j]) {
            x = myrec(s, t, i + 1, j + 1, dp);
        }
        y = myrec(s, t, i + 1, j, dp);

        return dp[i][j] = x + y;
    }

    int numDistinct(string s, string t) {
        vector<vector<int>> dp(s.size(), vector<int>(t.size(), -1));
        return myrec(s, t, 0, 0, dp);
    }
};