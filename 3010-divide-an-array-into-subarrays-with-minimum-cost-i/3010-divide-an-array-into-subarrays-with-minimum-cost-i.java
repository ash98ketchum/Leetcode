class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++){
            if(nums[i] < min){
                smin = min;
                min = nums[i];
            }else if(nums[i] < smin){
                smin = nums[i];
            }
        }
        return nums[0] + min + smin;
    }
}