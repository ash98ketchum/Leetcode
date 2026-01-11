class Solution {
public:

    int maxRotateFunction(vector<int>& nums) {
        int ans = -2e9;
        for(int i = 0; i < nums.size(); i++){
            int sum = 0;
            int cnt = 0;
            for(int j = i; j < (nums.size() + i); j++){
                sum += (cnt * nums[j % nums.size()]);
                cnt++;
            }
            ans = max(sum, ans);
        }
        return ans;
    }
};