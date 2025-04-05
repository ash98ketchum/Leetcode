class Solution {
    // public static int myrec(int idx1, int idx2, String s, String t, int dp[][]){
    //     if(idx1 < 0 || idx2 < 0){
    //         return 0;
    //     }
    //     if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
    //     if(s.charAt(idx1) == t.charAt(idx2)){
    //         return dp[idx1][idx2]= 1 + myrec(idx1 - 1, idx2 - 1, s, t, dp);
    //     }
    //     else{
    //         return dp[idx1][idx2] = Math.max(myrec(idx1 - 1, idx2, s, t, dp), myrec(idx1, idx2 - 1, s, t, dp));
    //     }
    // }
    public int minInsertions(String s) {
        int n = s.length();
        String t = "";
        int i2 = n -1;
        while(i2 >= 0){
            t += s.charAt(i2);
            i2--;
        }
        int dp[][] = new int[n][n];
        
        dp[0][0] = (s.charAt(0) == t.charAt(0)) ? 1 : 0;
        for(int i = 1; i < n; i++){
            dp[i][0] = (s.charAt(i) == t.charAt(0)) ? 1 : dp[i-1][0];
            dp[0][i] = (s.charAt(0) == t.charAt(i)) ? 1 : dp[0][i-1];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return n - dp[n-1][n-1];
    }
}