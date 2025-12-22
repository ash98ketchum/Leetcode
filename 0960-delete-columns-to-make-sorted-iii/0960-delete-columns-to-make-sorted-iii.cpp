class Solution {
    int n, m;
    vector<vector<int>> dp;

    int myrec(int curr, int prev, vector<string>& strs) {
        if (curr == m) return 0;
        if (dp[curr][prev + 1] != -1) return dp[curr][prev + 1];

        int res = myrec(curr + 1, prev, strs);

        bool f = true;
        if (prev != -1) {
            for (int i = 0; i < n; i++) {
                if (strs[i][prev] > strs[i][curr]) {
                    f = false;
                    break;
                }
            }
        }

        if (f) {
            res = max(res, 1 + myrec(curr + 1, curr, strs));
        }

        return dp[curr][prev + 1] = res;
    }

public:
    int minDeletionSize(vector<string>& strs) {
        n = strs.size();
        m = strs[0].size();
        dp.assign(m, vector<int>(m + 1, -1));
        return m - myrec(0, -1, strs);
    }
};
