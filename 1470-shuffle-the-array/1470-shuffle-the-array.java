class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[2 * n];
        for(int i = 0, idx = 0; idx < 2 * n - 1 && i < n; i++,idx+=2){
            ans[idx] = nums[i];
            ans[idx + 1] = nums[i+n];
        }
        return ans;
    }
}