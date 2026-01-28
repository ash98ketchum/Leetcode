class Solution {
    public int myrec(int nums[], int k, int idx){
        if(idx >= nums.length - 1) return nums[idx];
        
        int take = nums[idx];
        int sum = Integer.MIN_VALUE;
        
        for(int i = idx + 1; i <= Math.min(nums.length -1, idx + k); i++){
            sum = Math.max(sum, take + myrec(nums, k, i));
        } 
        return sum;
    }
    public int maxResult(int[] nums, int k) {
        return myrec(nums, k, 0);
    }
}