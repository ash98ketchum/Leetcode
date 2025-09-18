class Solution {
public:
    int myrec(vector<int> &nums, int i, int j, vector<vector<int>> &dp){
        if(i + 1 == j){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        for(int k = i +1; k < j; k++){
            int x = myrec(nums, i , k , dp);
            int y = myrec(nums, k, j, dp);
            int z = nums[i] * nums[j] * nums[k];
            ans = max(ans, x + y + z);
        }
        return dp[i][j] = ans;

    }
    int maxCoins(vector<int>& nums) {
        nums.insert(nums.begin(), 1);
        nums.push_back(1);

        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, -1));
        return myrec(nums, 0, n - 1, dp);
    }
};