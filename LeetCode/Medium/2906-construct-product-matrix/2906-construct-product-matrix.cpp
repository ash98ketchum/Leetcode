class Solution {
public:
    const int MOD = 12345;

    vector<vector<int>> constructProductMatrix(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        int sz = n * m;
        vector<int> arr;
        for(auto &row : grid){
            for(auto &x : row){
                arr.push_back(x % MOD);
            }
        }

        vector<int> prefix(sz, 1), suffix(sz, 1);
        for(int i = 1; i < sz; i++){
            prefix[i] = (prefix[i-1] * arr[i-1]) % MOD;
        }
        for(int i = sz - 2; i >= 0; i--){
            suffix[i] = (suffix[i+1] * arr[i+1]) % MOD;
        }

        vector<vector<int>> res(n, vector<int>(m));
        for(int i = 0; i < sz; i++){
            int val = (prefix[i] * suffix[i]) % MOD;
            res[i / m][i % m] = val;
        }

        return res;
    }
};