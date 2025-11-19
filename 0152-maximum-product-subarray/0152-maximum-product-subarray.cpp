class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxx = nums[0], minn = nums[0], ans = nums[0];
        for(int i = 1; i < nums.size(); i++){
            if(nums[i] <= 0){
                swap(maxx, minn);
            }
            maxx = max(maxx * nums[i], nums[i]);
            minn = min(minn * nums[i], nums[i]);
            ans = max(ans, maxx);
        }
        return ans;
    }
};