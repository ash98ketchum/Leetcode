class Solution {
public:
    bool canPartitionGrid(vector<vector<int>>& grid) {
        // vertical
        int n = grid.size();
        int m = grid[0].size();
        long long tot = 0;
        for(auto it : grid) for(auto it2 : it) tot += it2;

        long long sum = 0;
        for(int j = 0; j < m; j++){
            for(int i = 0; i < n; i++){
                sum += grid[i][j];
            }
            if(sum == (tot - sum)) return true;
        }
        sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sum += grid[i][j];
            }
            if(sum == (tot - sum)) return true;
        }
        return false;
    }

};