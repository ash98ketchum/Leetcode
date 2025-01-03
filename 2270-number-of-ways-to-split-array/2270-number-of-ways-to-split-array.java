class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        
        int count = 0;
        long totalSum = prefixSum[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (prefixSum[i] >= totalSum - prefixSum[i]) {
                count++;
            }
        }
        
        return count;
    }
}
