class Solution {
    // public static int myrec(int idx1,int idx2, String text1, String text2, int dp[][]){
    //     if (idx1 < 0 || idx2 < 0) {
    //         return 0;
    //     }
    //     if (text1.charAt(idx1) == text2.charAt(idx2)) {
    //         return dp[idx1][idx2]=1 + myrec(idx1 - 1, idx2 - 1, text1, text2, dp);
    //     }
    //     if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
    //     int cnt1 = myrec(idx1 - 1, idx2, text1, text2,dp);
    //     int cnt2 = myrec(idx1, idx2 - 1, text1, text2,dp);
    //     return dp[idx1][idx2]= Math.max(cnt1, cnt2);
        
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int dp[][] = new int[n1][n2];
        if(text1.charAt(0) == text2.charAt(0)){
            dp[0][0] = 1;
        }
        for(int i = 1; i < n1; i++){
            if(text1.charAt(i) == text2.charAt(0)){
                dp[i][0] = 1;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int j = 1; j < n2; j++){
            if(text1.charAt(0) == text2.charAt(j)){
                dp[0][j] = 1;
            }
            else{
                dp[0][j] = dp[0][j-1];
            }
            
        }
        for(int i = 1; i < n1; i++){
            for(int j = 1; j < n2; j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1-1][n2-1];
    }
}