class Solution {
public:
    bool canFormPairs(int mid, vector<int>& nums, int k) {
        int count = 0, left = 0;
        for (int right = 0; right < nums.size(); ++right) {
            while (nums[right] - nums[left] > mid) {
                ++left;
            }
            count += right - left;
        }
        return count >= k;
    }

    int smallestDistancePair(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int start = 0;
        int end = nums.back() - nums.front();
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canFormPairs(mid, nums, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
};
