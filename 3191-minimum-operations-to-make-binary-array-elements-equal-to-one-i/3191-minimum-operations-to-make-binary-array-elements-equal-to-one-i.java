class Solution {
    public int minOperations(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for(int i = 0; i < n-2; i++){
            if(nums[i] == 1) continue;
            if(nums[i] == 0 || nums[i+1] == 0 || nums[i+2] == 0){
                cnt++;
                nums[i] = nums[i] == 1?0:1;
                nums[i + 1] = nums[i+1] == 1?0:1;
                nums[i + 2] = nums[i+2] == 1?0:1;
            }
        }
        if(nums[n-1] == 0 || nums[n-2] == 0 || nums[n-3] == 0){
            return -1;
        }
        return cnt;
    }
}