class Solution {
    public int wiggleMaxLength(int[] nums) {
        int low = 1, high = 1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i]>nums[i-1])
                high = low +1;
            if(nums[i]<nums[i-1])
                low = high +1;
        }
        return Math.max(low, high);
    }
}