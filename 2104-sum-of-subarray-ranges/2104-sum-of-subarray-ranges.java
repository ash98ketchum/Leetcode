class Solution {

    public long sumSubarrayMins(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        long ans = 0;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] > nums[i])) {
                int idx = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                ans += (long) nums[idx] * (idx - left) * (right - idx);
            }
            st.push(i);
        }
        return ans;
    }

    public long sumSubarrayMaxs(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        long ans = 0;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] < nums[i])) {
                int idx = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                ans += (long) nums[idx] * (idx - left) * (right - idx);
            }
            st.push(i);
        }
        return ans;
    }

    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }
}
