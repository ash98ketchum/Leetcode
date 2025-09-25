class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //state -> minimum path sum upto(i,j) from the top the triangle
        //transition -> 

        // base -> dp[0][0] = triangle[0][0];
        // final problem -> dp[0][0];
        int n = triangle.size();
        int dp[][] = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i ; j++){
                if(j > 0 && j < i){
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j-1]);
                } 
                else if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
                } 
                else {
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;

    }
}