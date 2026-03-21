class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        vector<int> nums;
        for(auto it : nums1) nums.push_back(it);
        for(auto it : nums2) nums.push_back(it);
        sort(nums.begin(), nums.end());
        int len = nums.size();
        if(len & 1) return (double)nums[len/2];
        return ((double)nums[len/2 - 1] + nums[len/2]) / 2.0;
    }
};