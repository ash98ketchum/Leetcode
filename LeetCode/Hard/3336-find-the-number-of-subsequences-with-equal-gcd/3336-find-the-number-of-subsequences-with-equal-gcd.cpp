class Solution {
    const int MOD = 1e9 + 7;
    
    int solve(int i, int j, int k, const vector<int>& nums, vector<vector<vector<int>>>& memo) {
        if (i == nums.size()) {
            return (j > 0 && j == k) ? 1 : 0;
        }
        if (memo[i][j][k] != -1) {
            return memo[i][j][k];
        }

        long long ways = 0;

        ways = (ways + solve(i + 1, j, k, nums, memo)) % MOD;
        ways = (ways + solve(i + 1, std::gcd(j, nums[i]), k, nums, memo)) % MOD;
        ways = (ways + solve(i + 1, j, std::gcd(k, nums[i]), nums, memo)) % MOD;

        return memo[i][j][k] = ways;
    }

public:
    int subsequencePairCount(vector<int>& nums) {
        int n = nums.size();
        int maxNum = 0;
        for (int x : nums) {
            maxNum = max(maxNum, x);
        }
        vector<vector<vector<int>>> memo(n, vector<vector<int>>(maxNum + 1, vector<int>(maxNum + 1, -1)));
        return solve(0, 0, 0, nums, memo);
    }
};