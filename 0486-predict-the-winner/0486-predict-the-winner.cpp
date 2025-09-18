class Solution {
public:
    int myrec(int idx, int idy, int turn, vector<int>& arr, vector<vector<vector<int>>>& dp) {
        if (idx > idy) {
            return 0;
        }
        if (dp[idx][idy][turn] != -1) {
            return dp[idx][idy][turn];
        }
        if (turn == 0) {
            int score1 = arr[idx] + myrec(idx + 1, idy, 1, arr, dp);
            int score2 = arr[idy] + myrec(idx, idy - 1, 1, arr, dp);
            dp[idx][idy][turn] = max(score1, score2);
        } else {
            int score1 = myrec(idx + 1, idy, 0, arr, dp);
            int score2 = myrec(idx, idy - 1, 0, arr, dp);
            dp[idx][idy][turn] = min(score1, score2);
        }
        return dp[idx][idy][turn];
    }
    
    bool predictTheWinner(vector<int>& nums) {
        int n = nums.size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(n, vector<int>(2, -1)));
        int ans = myrec(0, n - 1, 0, nums, dp);
        int tot = 0;
        for (auto i : nums) {
            tot += i;
        }
        return tot - ans <= ans;
    }
};
