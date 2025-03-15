class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // state -> minimum sum of paths from bottom row to any index (i,j)
        //transition -> dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);

        //base case -> dp[n-1][j] = triangle.get(n-1)(j);
        //final subproblem dp[0][0];

        int n = triangle.size();
        int dp[][] = new int[n][n];

        //base case filling
        for(int j = 0; j < n; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}