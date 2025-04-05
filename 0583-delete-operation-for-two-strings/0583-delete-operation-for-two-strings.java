class Solution {
    // public static int myrec(int idx1, int idx2, String word1, String word2, int dp[][]){
    //     if(idx1 < 0 || idx2 <0){
    //         return 0;
    //     }
    //     if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
    //     if(word1.charAt(idx1) == word2.charAt(idx2)){
    //         return dp[idx1][idx2] = 1 + myrec(idx1 - 1, idx2 - 1, word1, word2, dp);
    //     }
    //     else{
    //         return dp[idx1][idx2] = Math.max(myrec(idx1 - 1, idx2, word1, word2, dp), myrec(idx1, idx2 - 1, word1, word2, dp));
    //     }
    // }
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int dp[][] = new int[n1][n2];
        dp[0][0] = (word1.charAt(0) == word2.charAt(0)) ? 1 : 0;
        for(int i = 1; i < n1; i++){
            if(word1.charAt(i) == word2.charAt(0)){
                dp[i][0] = 1;
            }
            else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int i = 1; i < n2; i++){
            if(word1.charAt(0) == word2.charAt(i)){
                dp[0][i] = 1;
            }
            else{
                dp[0][i] = dp[0][i-1];
            }
        }

        for(int i = 1; i < n1; i++){
            for(int j = 1; j < n2; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }
        return n1 + n2 - (2 * dp[n1-1][n2 - 1]);

    }
}