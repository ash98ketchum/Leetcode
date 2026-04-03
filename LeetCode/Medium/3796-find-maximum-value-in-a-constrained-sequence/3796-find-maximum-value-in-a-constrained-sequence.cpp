class Solution {
public:
    int findMaxVal(int n, vector<vector<int>>& restrictions, vector<int>& diff) {
        vector<int> res(n, 1e9);

        for (auto& r : restrictions) {
            res[r[0]] = r[1];
        }

        for (int i = n - 2; i >= 0; i--) {
            res[i] = min(res[i], res[i + 1] + diff[i]);
        }

        res[0] = 0;

        int ans = 0;
        for (int i = 1; i < n; i++) {
            res[i] = min(res[i], res[i - 1] + diff[i - 1]);
            ans = max(ans, res[i]);
        }

        return ans;
    }
};