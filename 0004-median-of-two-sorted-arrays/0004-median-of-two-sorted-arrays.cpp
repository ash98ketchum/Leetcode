class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.size();
        int m = nums2.size();
        int tot = n + m;

        int low = 0, high = n;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (tot + 1) / 2 - mid1;

            int left1  = (mid1 == 0) ? INT_MIN : nums1[mid1 - 1];
            int right1 = (mid1 == n) ? INT_MAX : nums1[mid1];
            int left2  = (mid2 == 0) ? INT_MIN : nums2[mid2 - 1];
            int right2 = (mid2 == m) ? INT_MAX : nums2[mid2];

            if (left1 <= right2 && left2 <= right1) {
                if (tot % 2 == 0) {
                    long long a = max(left1, left2);
                    long long b = min(right1, right2);
                    return (a + b) / 2.0;
                } else {
                    return max(left1, left2);
                }
            } else if (left1 > right2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0.0;
    }
};
