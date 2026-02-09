class Solution {
public:
    int dominantIndices(vector<int>& nums) {
        int n = nums.size();
        int cnt = 0;
        int sum = nums[n - 1];
        int len = 1;
        for(int i= n - 2; i >= 0; i--){
            if((sum/len) < nums[i]) cnt++;
            sum += nums[i];
            len++;
        }
        return cnt;
    }
};