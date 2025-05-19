class Solution {
    public static int divyanshicutu(int nums[], int k){
         int s = 0, e = 0;
        int cnt = 0;
        int ans = 0;
        while(e < nums.length){
            // grow
            if(nums[e] % 2  != 0){
              cnt++;
            }
            // shrink

            
            while(s <= e && cnt > k){
               if(nums[s] % 2 != 0){
                 cnt--;
               }
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
    public int numberOfSubarrays(int[] nums, int k) {
       return divyanshicutu(nums, k) - divyanshicutu(nums, k - 1);
    }
}