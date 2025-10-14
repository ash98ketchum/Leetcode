class Solution {
public:
    bool hasIncreasingSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        if (n < 2 * k) return false;

        auto isIncreasing = [&](int start) {
            for (int i = start + 1; i < start + k; ++i) {
                if (nums[i] <= nums[i - 1]) return false;
            }
            return true;
        };

        for (int i = 0; i <= n - 2 * k; ++i) {
            if (isIncreasing(i) && isIncreasing(i + k)) {
                return true;
            }
        }
        return false;
    }
};