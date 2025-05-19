class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int s = 0, e = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(e < nums.length){
            // grow
            sum += nums[e];
           // shrink
            while(s <= e && sum >= target){
                
                if(sum >= target){
                min = Math.min(min, e-s + 1);
                 }

                 sum -= nums[s];
                s++;
            }
            // ans update
            if(sum >= target){
                min = Math.min(min, e-s + 1);
            }
            e++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}