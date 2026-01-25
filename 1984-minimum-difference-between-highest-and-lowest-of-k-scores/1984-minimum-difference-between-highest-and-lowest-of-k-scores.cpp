class Solution {
public:
    int minimumDifference(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        if(k == 1) return 0;
        int ans = 1e9;
        for(int i = 0; i < n; i++){
            if((i + k - 1) < n){
                ans = min(ans, nums[i + k - 1] - nums[i]);
            }
        }
        return ans;
    }
};