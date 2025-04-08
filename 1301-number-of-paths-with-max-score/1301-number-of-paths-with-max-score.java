class Solution {
    // public static int myrec1(int i, int j, List<String> board, int n, int dp[][]){
    //     if (i < 0 || j < 0 || board.get(i).charAt(j) == 'X') {
    //         return -1000000000;
    //     }

    //     if (i == 0 && j == 0) {
    //         return 0;
    //     }
    //     if(dp[i][j] != -1) return dp[i][j];
    //     int val = 0;
    //     char cell = board.get(i).charAt(j);
    //     if (cell >= '0' && cell <= '9') {
    //         val = cell - '0';
    //     }
    //     if (i == n - 1 && j == n - 1) {
    //         val = 0;
    //     }

    //     int ans = Math.max(
    //         myrec1(i - 1, j, board, n,dp),
    //         Math.max(
    //             myrec1(i, j - 1, board, n, dp),
    //             myrec1(i - 1, j - 1, board, n, dp)
    //         )
    //     );

    //     return dp[i][j] = val + ans;
    // }
    // public static int myrec2(int i, int j, int n, List<String> board, int target, int[][][] dp){
    //     if (i < 0 || j < 0 || board.get(i).charAt(j) == 'X') {
    //         return 0;
    //     }
    //     if (i == 0 && j == 0) {
    //         return target == 0 ? 1 : 0;
    //     }
    //     if (target < 0) return 0; // no valid path can reach here

    //     if (dp[i][j][target] != -1) return dp[i][j][target];

    //     int val = 0;
    //     char cell = board.get(i).charAt(j);
    //     if (cell >= '0' && cell <= '9') {
    //         val = cell - '0';
    //     }
    //     if (i == n - 1 && j == n - 1) {
    //         val = 0;
    //     }

    //     int ans = (
    //         myrec2(i - 1, j, n, board, target - val, dp) +
    //         myrec2(i, j - 1, n, board, target - val, dp) +
    //         myrec2(i - 1, j - 1, n, board, target - val, dp)
    //     ) % 1000000007;

    //     return dp[i][j][target] = ans;
    // }

    public int[] pathsWithMaxScore(List<String> board) {
        // int n = board.size();
        // int dp1[][] = new int[n][n];
        // for(int i = 0; i < n; i ++){
        //     for(int j = 0; j < n; j++){
        //         dp1[i][j] = -1;
        //     }
        // }
        
        // int maxscore = Math.max(0,myrec1(n-1, n-1, board, n, dp1));
        // int[][][] dp2 = new int[n][n][maxscore + 1];
        // for (int[][] mat : dp2)
        //     for (int[] row : mat)
        //         Arrays.fill(row, -1);
        // int maxpaths = myrec2(n-1, n-1, n, board, maxscore, dp2);
        int n = board.size();
        int MOD = 1000000000+7;
        int[][] dpScore = new int[n][n];
        for (int[] row : dpScore) Arrays.fill(row, -1);

        dpScore[0][0] = 0;

        // STEP 1: Compute maximum score to each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char cell = board.get(i).charAt(j);
                if (cell == 'X') continue;
                if (i == 0 && j == 0) continue;

                int maxPrev = -1;
                int[][] dirs = {{-1, 0}, {0, -1}, {-1, -1}};
                for (int[] d : dirs) {
                    int pi = i + d[0], pj = j + d[1];
                    if (pi >= 0 && pj >= 0 && dpScore[pi][pj] != -1) {
                        maxPrev = Math.max(maxPrev, dpScore[pi][pj]);
                    }
                }

                if (maxPrev == -1) continue; // unreachable

                int add = 0;
                if (cell >= '0' && cell <= '9') add = cell - '0';
                if (i == n - 1 && j == n - 1) add = 0; // no score from 'S'

                dpScore[i][j] = maxPrev + add;
            }
        }

        int maxScore = dpScore[n - 1][n - 1];
        if (maxScore == -1) return new int[]{0, 0}; // unreachable

        // STEP 2: Count paths that yield exactly maxScore
        int[][] dpPaths = new int[n][n];
        dpPaths[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char cell = board.get(i).charAt(j);
                if (cell == 'X') continue;
                if (i == 0 && j == 0) continue;

                int add = 0;
                if (cell >= '0' && cell <= '9') add = cell - '0';
                if (i == n - 1 && j == n - 1) add = 0;

                int[][] dirs = {{-1, 0}, {0, -1}, {-1, -1}};
                for (int[] d : dirs) {
                    int pi = i + d[0], pj = j + d[1];
                    if (pi >= 0 && pj >= 0 && dpScore[pi][pj] != -1) {
                        if (dpScore[pi][pj] + add == dpScore[i][j]) {
                            dpPaths[i][j] = (dpPaths[i][j] + dpPaths[pi][pj]) % MOD;
                        }
                    }
                }
            }
        }

        int numPaths = dpPaths[n - 1][n - 1];
        return new int[]{maxScore, numPaths};
    }
}