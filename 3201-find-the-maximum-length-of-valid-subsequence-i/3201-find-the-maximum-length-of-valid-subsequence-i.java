class Solution {
    public int maximumLength(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        for (int it : nums) {
            if (it % 2 == 0) cnt1++;
            else cnt2++;
        }

        int eve = 0, odd = 0;
        for (int it : nums) {
            if (it % 2 == 0)
                eve = Math.max(eve, odd + 1);
            else
                odd = Math.max(odd, eve + 1);
        }

        return Math.max(cnt1, Math.max(cnt2, Math.max(eve, odd)));
    }
}