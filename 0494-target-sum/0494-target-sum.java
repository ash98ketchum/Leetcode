class Solution {
    // public static int myrec(int idx, int target, int nums[], int dp[][]){
    //     if(idx == 0){
    //         if(nums[0] == 0 && target == 0){
    //             return 2;
    //         }
    //         else if(nums[0] == target || target == 0){
    //             return 1;
    //         }
    //         else{
    //             return 0;
    //         }
    //     }
    //     if(dp[idx][target] != -1) return dp[idx][target];
    //     int cnt = 0;
    //     cnt += myrec(idx - 1, target, nums, dp);
    //     if(target - nums[idx] >= 0){
    //         cnt += myrec(idx - 1, target - nums[idx], nums, dp);
    //     }
    //     return dp[idx][target] = cnt;
    // }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int tot = 0;
        for(int it: nums){
            tot += it;
        }
        if(tot - target < 0 || (tot - target) % 2 == 1){
            return 0;
        }
        int x = (tot - target)/2;

        int dp[][] = new int[n][x+1];
        
        if(nums[0] == 0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] = 1;
            if(x >= nums[0]){
                dp[0][nums[0]] = 1;
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= x; j++){
                dp[i][j] = dp[i-1][j];
                if(j - nums[i] >= 0){
                    dp[i][j] += dp[i-1][j- nums[i]];
                }
            }
        }
        return dp[n-1][x];
    }
}