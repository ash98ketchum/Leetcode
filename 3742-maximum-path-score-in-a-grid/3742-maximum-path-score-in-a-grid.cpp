class Solution {
public:
    int n, m;
    vector<vector<vector<int>>> dp;

    int dfs(vector<vector<int>>& grid, int r, int c, int costLeft) {
        if (r >= n || c >= m || costLeft < 0) return -1e9;

        int cellVal = grid[r][c];
        int addScore = (cellVal == 2 ? 2 : (cellVal == 1 ? 1 : 0));
        int addCost  = (cellVal == 2 ? 1 : (cellVal == 1 ? 1 : 0));

        costLeft -= addCost;
        if (costLeft < 0) return -1e9;

        if (r == n - 1 && c == m - 1)
            return addScore;

        if (dp[r][c][costLeft] != -1)
            return dp[r][c][costLeft];

        int right = dfs(grid, r, c + 1, costLeft);
        int down  = dfs(grid, r + 1, c, costLeft);

        return dp[r][c][costLeft] = addScore + max(right, down);
    }

    int maxPathScore(vector<vector<int>>& grid, int k) {
        n = grid.size();
        m = grid[0].size();
        dp.assign(n, vector<vector<int>>(m, vector<int>(k + 1, -1)));

        int ans = dfs(grid, 0, 0, k);
        return (ans < 0 ? -1 : ans);
    }
};
