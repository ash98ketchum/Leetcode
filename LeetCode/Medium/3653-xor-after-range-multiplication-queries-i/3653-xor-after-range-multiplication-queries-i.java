class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int MOD = 1_000_000_000 + 7;
        for(int it[] : queries){
            int l = it[0];
            int r = it[1];
            int k =it[2];
            long v = (long)it[3];
            if(v == 1) continue;

            for(int i = l; i <=r; i+=k){
                nums[i] = (int)(((long)(nums[i]%MOD )* (v%MOD)) %MOD);
            }
        }
        int ans = 0;
        for(int it : nums){
            ans^=it;
        }
        return ans;
    }
}