class Solution {
public:
    bool isMiddleElementUnique(vector<int>& nums) {
        int n = nums.size();
        int ele = nums[n/2];
        for(int i = 0; i < n; i++) if(i != n/2 && ele == nums[i]) return false;
        return true;
    }
};