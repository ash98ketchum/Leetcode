class Solution {
    public static int myrec1(int i, int j, List<String> board, int n, int dp[][]){
        if (i < 0 || j < 0 || board.get(i).charAt(j) == 'X') {
            return -1000000000;
        }

        if (i == 0 && j == 0) {
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int val = 0;
        char cell = board.get(i).charAt(j);
        if (cell >= '0' && cell <= '9') {
            val = cell - '0';
        }
        if (i == n - 1 && j == n - 1) {
            val = 0;
        }

        int ans = Math.max(
            myrec1(i - 1, j, board, n,dp),
            Math.max(
                myrec1(i, j - 1, board, n, dp),
                myrec1(i - 1, j - 1, board, n, dp)
            )
        );

        return dp[i][j] = val + ans;
    }
    public static int myrec2(int i, int j, int n, List<String> board, int target, int[][][] dp){
        if (i < 0 || j < 0 || board.get(i).charAt(j) == 'X') {
            return 0;
        }
        if (i == 0 && j == 0) {
            return target == 0 ? 1 : 0;
        }
        if (target < 0) return 0; // no valid path can reach here

        if (dp[i][j][target] != -1) return dp[i][j][target];

        int val = 0;
        char cell = board.get(i).charAt(j);
        if (cell >= '0' && cell <= '9') {
            val = cell - '0';
        }
        if (i == n - 1 && j == n - 1) {
            val = 0;
        }

        int ans = (
            myrec2(i - 1, j, n, board, target - val, dp) +
            myrec2(i, j - 1, n, board, target - val, dp) +
            myrec2(i - 1, j - 1, n, board, target - val, dp)
        ) % 1000000007;

        return dp[i][j][target] = ans;
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int dp1[][] = new int[n][n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                dp1[i][j] = -1;
            }
        }
        
        int maxscore = Math.max(0,myrec1(n-1, n-1, board, n, dp1));
        int[][][] dp2 = new int[n][n][maxscore + 1];
        for (int[][] mat : dp2)
            for (int[] row : mat)
                Arrays.fill(row, -1);
        int maxpaths = myrec2(n-1, n-1, n, board, maxscore, dp2);
        int res[] = new int[2];
        res[0] = maxscore;
        res[1] = maxpaths;
        return res;
    }
}