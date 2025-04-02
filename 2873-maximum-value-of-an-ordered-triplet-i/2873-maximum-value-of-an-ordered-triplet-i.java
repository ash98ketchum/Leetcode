class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        int n = nums.length;
        int lmax[] = new int[n];
        int rmax[] = new int[n];
        lmax[0] = -1;
        rmax[n-1] = -1;
        int val1 = nums[0], val2 = nums[n-1];
        for(int i = 1; i < n; i ++){
            lmax[i] = Math.max(val1, nums[i-1]);
            val1 = lmax[i];
        }
        for(int i = n-2; i >=0; i--){
            rmax[i] = Math.max(val2,nums[i+1]);
            val2 = rmax[i];
        }

        for(int i = 1; i < n-1; i++){
            res = Math.max(res, (long)(lmax[i] - nums[i]) * rmax[i]);
        }
        return res;
        
    }
}