class Solution {
public:
    int countMajoritySubarrays(vector<int>& nums, int target) {
        int cnt = 0;
        int n = nums.size();
        for(int i = 0; i < n; i++){
            int val = 0;
            for(int j = i; j < n; j++){
                if(nums[j] == target) val++;
                if(val > (j - i + 1)/2) cnt++;
            }
        }
        return cnt;
    }
};