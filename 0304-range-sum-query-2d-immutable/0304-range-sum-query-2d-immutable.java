class NumMatrix {
    static int  pref[][];
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        pref = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                pref[i][j] = matrix[i-1][j-1] + pref[i-1][j] + pref[i][j-1] - pref[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        return pref[r2 + 1][c2 + 1] - pref[r1 - 1 + 1][c2 + 1] - pref[r2 + 1][c1-1 + 1] + pref[r1-1 + 1][c1-1 + 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */