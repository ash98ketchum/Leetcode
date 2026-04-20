class Solution {
    int n;
    vector<int> a;
    vector<vector<int>> memo;

    int solve(int i, int diff) {
        if (i == n) {
            return (diff == 0) ? 0 : -1e9; 
        }
        if (memo[i][diff] != -1) return memo[i][diff];

        int skip = solve(i + 1, diff);
        int add_to_taller = a[i] + solve(i + 1, diff + a[i]);
        int add_to_shorter = solve(i + 1, abs(diff - a[i])) + max(0, a[i] - diff);

        return memo[i][diff] = max({skip, add_to_taller, add_to_shorter});
    }

public:
    int tallestBillboard(vector<int>& rods) {
        n = rods.size();
        a = rods;
        memo.assign(n, vector<int>(5005, -1));
        return solve(0, 0);
    }
};