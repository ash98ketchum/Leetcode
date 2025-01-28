class Solution {
    private int R, C;
    private boolean[][] visited;
    private int[][] grid;
    private int dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= R || c >= C || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        int fishCount = grid[r][c];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            fishCount += dfs(newRow, newCol);
        }
        return fishCount;
    }

    public int findMaxFish(int[][] grid) {
        this.R = grid.length;
        this.C = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[R][C];

        int maxFish = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    maxFish = Math.max(maxFish, dfs(i, j));
                }
            }
        }

        return maxFish;
    }
}
