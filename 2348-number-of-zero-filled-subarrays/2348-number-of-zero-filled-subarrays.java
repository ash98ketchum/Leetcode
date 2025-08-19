class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long tot = 0;
        int n = nums.length;
        long cnt = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                cnt++;
            }
            else{
                tot += (cnt * (cnt + 1))/2;
                cnt = 0;
            }
            
        }
        tot += (cnt * (cnt + 1))/2;
        return tot;
    }
}