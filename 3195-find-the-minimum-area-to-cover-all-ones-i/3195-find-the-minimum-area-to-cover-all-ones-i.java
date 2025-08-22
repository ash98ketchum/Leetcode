class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int r1 = n, r2 = -1;
        int c1 = m, c2 = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    r1 = Math.min(r1, i);
                    r2 = Math.max(r2, i);
                    c1 = Math.min(c1, j);
                    c2 = Math.max(c2, j);
                }
            }
        }

        if (r2 == -1) return 0;

        int height = r2 - r1 + 1;
        int width  = c2 - c1 + 1;
        return height * width;
    }
}
