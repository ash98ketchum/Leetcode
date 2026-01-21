class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long MOD = 1000000007;

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }

        long ans = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] > nums[i])) {
                int idx = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                long sum = pref[right] - pref[left + 1];
                ans = Math.max(ans, sum * nums[idx]);
            }
            st.push(i);
        }

        return (int)(ans % MOD);
    }
}
