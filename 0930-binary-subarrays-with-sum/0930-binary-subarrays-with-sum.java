class Solution {
    public static int anirudh(int nums[], int goal){
        int s = 0, e = 0;
        int cnt = 0;
        int ans = 0;
        int sum = 0;
        while(e < nums.length){
            // grow
            sum += nums[e];
            // shrink

            
            while(s <= e && sum > goal){
               sum -= nums[s];
               s++;
            }

            // ans update

            // jb hamari window ke andar x subaaray hai to window ka size ek se increase krdu to subarr ka count x + x + 1 hojaega
            ans += (e - s + 1);
            e++;
        }
        return ans;
    }
    // hamse exactly k poocha tha we find atmost k(0 to k and 0 to k-1) and subtract them to make exactly k
    public int numSubarraysWithSum(int[] nums, int goal) {
       return anirudh(nums, goal) - anirudh(nums, goal - 1);
    }
}