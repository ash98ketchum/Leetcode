class Solution {
    // public static int myrec(int idx, int target, int coins[], int dp[][]){
    //     if(idx == 0){
    //         if(target % coins[0] == 0){
    //             return 1;
    //         }
    //         else{
    //             return 0;
    //         }
    //     }
    //     if(dp[idx][target] != -1) return dp[idx][target];
    //     int notake = myrec(idx - 1, target, coins, dp);
    //     int take =0;
    //     if(target - coins[idx] >= 0){
    //         take = myrec(idx, target - coins[idx], coins, dp);
    //     }
    //     return dp[idx][target] = take + notake;

    // }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        
        for(int i = 0; i <= amount; i++){
            if(i % coins[0] == 0){
                dp[0][i] = 1;
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= amount; j++){
                int notake = dp[i-1][j];
                int take = 0;
                if(j - coins[i] >= 0){
                    take = dp[i][j- coins[i]];
                }
                dp[i][j] = take + notake;
            }
        }
        return dp[n-1][amount];
    }
}