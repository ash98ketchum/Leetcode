#include <vector>
#include <map>
#include <algorithm> // For std::min and std::max
#include <climits>   // For LLONG_MAX

using namespace std;

class Solution {
public:
    int maxFrequency(vector<int>& nums, int k, int numOperations) {
        map<int, int> cnt;
        map<int, int> diff; 

        for (int x : nums) {
            cnt[x]++;
            diff[x - k]++;
            diff[x + k + 1]--;
        }
        auto it_diff = diff.begin();
        auto it_cnt = cnt.begin();

        int potential = 0;
        int ans = 1;
        while (it_diff != diff.end() || it_cnt != cnt.end()) {
        
            long long coord_diff = (it_diff != diff.end()) ? it_diff->first : LLONG_MAX;
            long long coord_cnt = (it_cnt != cnt.end()) ? it_cnt->first : LLONG_MAX;
            long long current_coord = min(coord_diff, coord_cnt);

            if (current_coord == LLONG_MAX) {
                break;
            }
            if (coord_diff == current_coord) {
                potential += it_diff->second;
                it_diff++;
            }
            
            int already = 0;
            if (coord_cnt == current_coord) {
                already = it_cnt->second;
                it_cnt++;
            }
            int total_needed = potential - already;
            int freq = already + min(numOperations, total_needed);
            ans = max(ans, freq);
        }

        return ans;
    }
};