class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       //state - > minimum path sum to a point (i,j) from 0,0 starting point by going either i, i+1,
       //transition ->  dp[i][j] = a[i][j] + Min(dp[i-1][j-1], dp[i-1][j]);
       // base condition -> dp[0][0] = a[0][0];
       // final subproblem -> min(all the last rows) -> min(dp[n-1][j])

        int n = triangle.size();
        int dp[][] = new int[n][n];

        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < n ; i++){
            for(int j = 0; j <= i; j++){
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