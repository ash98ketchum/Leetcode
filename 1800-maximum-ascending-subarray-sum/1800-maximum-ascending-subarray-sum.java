class Solution {
    public int maxAscendingSum(int[] nums) {
        int i = 0;
        int n = nums.length;
        int globalsum = 0;

        while (i < n) {
            int currentsum = nums[i];
            while (i < n - 1 && nums[i] < nums[i + 1]) {
                currentsum += nums[i + 1];
                i++;
            }
            globalsum = Math.max(globalsum, currentsum);
            i++;
        }
        return globalsum;
    }
}
