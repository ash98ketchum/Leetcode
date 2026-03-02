class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<int> trz(n, 0);
        for(int i = 0; i < n; i++){
            int cnt = 0;
            int j = grid[i].size() - 1;
            while(j >= 0 && grid[i][j]== 0){
                j--;
                cnt++;
            }
            trz[i] = cnt;
        }

        int swaps = 0;

        for(int i = 0; i < n; i++){
            int need = n - 1 - i;
            int j = i;
            while (j < n && trz[j] < need) j++;
            if (j == n) return -1;
            while (j > i) {
                swap(trz[j], trz[j - 1]);
                swaps++;
                j--;
            }
        }

        return swaps;
    }
};