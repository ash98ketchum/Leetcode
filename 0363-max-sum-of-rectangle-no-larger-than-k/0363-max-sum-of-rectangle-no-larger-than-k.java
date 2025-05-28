class Solution {

    static int pref[][];

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int n = matrix.length;

        int m = matrix[0].length;

        pref = new int[n+1][m+1];



        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= m; j++){

                pref[i][j] = matrix[i-1][j-1] + pref[i-1][j] + pref[i][j-1] - pref[i-1][j-1];

            }

        }

        int max = Integer.MIN_VALUE;

        for(int r1 = 1; r1 <= n; r1 ++){

            for(int c1 = 1; c1 <= m; c1 ++){

                for(int r2 = r1; r2 <= n; r2++){

                    for(int c2 = c1; c2 <= m; c2++){

                        int sum = 0;

                        sum = pref[r2][c2] - pref[r1-1][c2] - pref[r2][c1-1] + pref[r1-1][c1-1]; 

                        if(sum <= k){

                            max = Math.max(max, sum);

                        }

                    }

                }

            }

        }

        return max;

    }

}