class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxx = nums[0];
        int minn = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.size(); i++){
            int temp = maxx;
            maxx = max({nums[i], maxx * nums[i], minn * nums[i]});
            minn = min({nums[i], temp * nums[i], minn * nums[i]});
            ans = max({ans, maxx});
        }
        return ans;
    }
};