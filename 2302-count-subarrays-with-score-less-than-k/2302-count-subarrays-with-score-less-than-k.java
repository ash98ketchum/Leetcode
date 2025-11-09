class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0, prod = 1, cnt = 0;
        int s = 0, e = 0;
        while(e < nums.length){
            sum += nums[e];
            prod = (sum * (e - s + 1));

            while(s <= e && prod >= k){
                sum -= nums[s];
                s++;
                if(e - s + 1 > 0) prod = (sum * (e - s + 1));
                else prod = 1;
            }
            cnt += (e - s + 1);
            e++;
        }
        return cnt;
    }
}