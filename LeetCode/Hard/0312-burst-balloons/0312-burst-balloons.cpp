class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<int> arr;
        arr.push_back(1);
        for(auto it : nums) arr.push_back(it);
        arr.push_back(1);

        vector<vector<int>> dp(n + 2, vector<int>(n + 2, 0));

        for(int len = 2; len <= n + 1; len++){
            for(int i = 0; i <= n + 1 - len; i++){
                int j = i + len;

                for(int k = i + 1; k < j; k++){
                    dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j] + (arr[i] * arr[j] * arr[k]));
                }
            }
        }
        return dp[0][n + 1];
    }
};