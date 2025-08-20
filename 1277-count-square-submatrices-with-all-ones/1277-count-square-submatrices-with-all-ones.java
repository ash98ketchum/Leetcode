class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for(int []it : dp) Arrays.fill(it, 0);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
            if(i == 0 && matrix[i][j] == 1){
                dp[i][j] = 1;
            }
            else if(j == 0 && matrix[i][j] == 1){
                dp[i][j] = 1;
            }
            else{
                if(matrix[i][j] == 1)
                dp[i][j] = Math.min(dp[i- 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
            }
        }
        }
        int sum = 0;
        for(int it[] : dp){
            for(int i : it){
                sum += i;
            }
        }
        return sum;
    }
}