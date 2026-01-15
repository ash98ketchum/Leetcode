class Solution {
public:
    long long maximumScore(vector<int>& nums, string s) {
        long long ans = 0;
        int currMax = -1;

        for (int i = 0; i < nums.size(); i++) {
            currMax = max(currMax, nums[i]);

            if (s[i] == '1') {
                ans += currMax;
                currMax = -1;
            }
        }
        return ans;
    }
};
