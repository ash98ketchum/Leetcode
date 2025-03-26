class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        long freq[] = new long[k];
        long sum = 0;
        freq[0] = 1;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            freq[(((int)sum%k)+k)%k]++;
        }
        int ans = 0;
        for(int i = 0 ; i < k; i++){
            if(freq[i] > 1){
                ans += ((freq[i]*(freq[i] -1))/2);
            }
        }
        return ans;
    }
}