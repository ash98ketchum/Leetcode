class Solution {
public:
    int countPartitions(vector<int>& nums) {
        int s1 = nums[0];
        int s2 = accumulate(nums.begin(), nums.end(), 0) - s1;
        int cnt = 0;
        if(abs(s2 - s1) % 2 == 0) cnt++;
        for(int i = 1; i < nums.size() - 1; i++){
            s1 += nums[i];
            s2 -= nums[i];
            if(abs(s2 - s1) % 2 == 0) cnt++;
        }
        return cnt;
    }
};