class Solution {
public:
    int dominantIndices(vector<int>& nums) {
        int n = nums.size();
        vector<int> avg(n);
        avg[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            avg[i] = avg[i + 1] + nums[i];
        }
        for(int i = 1; i <= n; i++){
            avg[i - 1]/= (n - i + 1);
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] > avg[i]) cnt++;
        }
        return cnt;
    }
};