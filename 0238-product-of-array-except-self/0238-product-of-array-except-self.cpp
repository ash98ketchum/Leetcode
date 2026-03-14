class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> suff(n, 1);
        for(int i = n - 2; i >= 0; i--){
            suff[i] = suff[i + 1] * nums[i+ 1];
        }
        vector<int> ans(n, 1);
        int prod = 1;
        for(int i = 0; i < n; i++){
            ans[i] = prod * suff[i];
            prod *= nums[i];
        }
        return ans;
    }
};