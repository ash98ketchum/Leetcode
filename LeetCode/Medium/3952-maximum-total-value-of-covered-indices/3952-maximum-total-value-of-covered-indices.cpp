class Solution {
public:
    vector<vector<long long>> dp;

    long long myrec(int idx, vector<int>&nums, string &s, int take){
        int n = s.size();
        if(idx >= n) return 0;
        if(dp[idx][take] != -1) return dp[idx][take];

        long long ans = myrec(idx + 1, nums, s, 0);
        if(s[idx] == '1' && !take){
            ans = max(ans, myrec(idx + 1, nums, s, 0) + nums[idx]);
        }
        if(idx + 1 < n && s[idx + 1] == '1'){
            ans = max(ans, myrec(idx + 1, nums, s, 1) + nums[idx]);
        }
        return dp[idx][take] = ans;
    }
    long long maxTotal(vector<int>& nums, string s) {
        int n = nums.size();
        dp.assign(n, vector<long long>(2, -1));
        return myrec(0,nums,s,0);
    }
};