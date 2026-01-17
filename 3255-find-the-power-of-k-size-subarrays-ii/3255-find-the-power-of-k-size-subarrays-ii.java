class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        int cnt1 = 0;
        int[] cons = new int[n];

        // build difference array
        for (int i = 1; i < n; i++) {
            cons[i] = nums[i] - nums[i - 1];
        }

        // first window (k-1 differences)
        for (int i = 1; i < k; i++) {
            if (cons[i] == 1) cnt1++;
        }

        int idx = 0;
        res[idx++] = (cnt1 == k - 1) ? nums[k - 1] : -1;

        // sliding window
        for (int i = k; i < n; i++) {
            if (cons[i] == 1) cnt1++;
            if (cons[i - k + 1] == 1) cnt1--;

            res[idx++] = (cnt1 == k - 1) ? nums[i] : -1;
        }

        return res;
    }
}
