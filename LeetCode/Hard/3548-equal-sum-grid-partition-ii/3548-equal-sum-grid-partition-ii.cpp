#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <cmath>

using namespace std;

class Solution {
public:
    bool canPartitionGrid(vector<vector<int>>& grid) {
        // 1. Check if a valid horizontal cut exists
        if (checkHorizontal(grid)) return true;
        
        // 2. Transpose the grid to reuse the horizontal logic for vertical cuts!
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> transposed(m, vector<int>(n));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                transposed[j][i] = grid[i][j];
            }
        }
        
        // 3. Check if a valid vertical cut exists (which is now horizontal in the transposed grid)
        return checkHorizontal(transposed);
    }

private:
    bool checkHorizontal(const vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        if (n <= 1) return false; 
        
        long long totalSum = 0;
        unordered_map<long long, int> botCounts; 
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                totalSum += grid[i][j];
                botCounts[grid[i][j]]++;
            }
        }
        
        long long topSum = 0;
        unordered_set<long long> topCounts; 

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                long long val = grid[i][j];
                topSum += val;
                topCounts.insert(val);
                botCounts[val]--;
                if (botCounts[val] == 0) {
                    botCounts.erase(val);
                }
            }
            
            long long botSum = totalSum - topSum;
            long long diff = topSum - botSum;
            
            // Case 1: Perfect match, no discounting needed
            if (diff == 0) return true; 
            
            // Case 2: Top section is heavier, try to discount a cell from the Top
            if (diff > 0) {
                int R = i + 1;
                
                if (R == 1 && m > 1) {
                    if (diff == grid[0][0] || diff == grid[0][m - 1]) return true;
                } else if (m == 1) {
                    if (diff == grid[0][0] || diff == grid[i][0]) return true;
                } else {
                    if (topCounts.count(diff)) return true;
                }
            } 
            // Case 3: Bottom section is heavier, try to discount a cell from the Bottom
            else {
                long long target = -diff;
                int R = n - 1 - i;
                
                if (R == 1 && m > 1) {
                    if (target == grid[i + 1][0] || target == grid[i + 1][m - 1]) return true;
                } else if (m == 1) {
                    if (target == grid[i + 1][0] || target == grid[n - 1][0]) return true;
                } else {
                    if (botCounts.count(target)) return true;
                }
            }
        }
        return false;
    }
};