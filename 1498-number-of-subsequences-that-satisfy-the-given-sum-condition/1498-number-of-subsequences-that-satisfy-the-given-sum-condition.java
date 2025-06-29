import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; ++i)
            pow2[i] = (pow2[i - 1] << 1) % MOD;

        long ans = 0;
        int l = 0, r = n - 1;

        while (l <= r) {
            if ((long) nums[l] + nums[r] <= target) {
                ans += pow2[r - l];
                if (ans >= MOD) ans -= MOD;
                ++l;
            } else {
                --r;        
            }
        }
        return (int) ans;
    }
}
