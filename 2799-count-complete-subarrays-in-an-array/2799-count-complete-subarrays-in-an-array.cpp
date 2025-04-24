#include <vector>
#include <unordered_map>
#include <unordered_set>
using namespace std;

class Solution {
public:
    int countCompleteSubarrays(vector<int>& nums) {
        int n = nums.size();
        unordered_set<int> all(nums.begin(), nums.end());
        int K = all.size();
        
        unordered_map<int,int> freq;
        int distinctInWindow = 0;
        long long ans = 0;
        
        int L = 0, R = 0;
        while (L < n) {
            while (R < n && distinctInWindow < K) {
                if (++freq[nums[R]] == 1) 
                    ++distinctInWindow;
                ++R;
            }
            if (distinctInWindow < K) 
                break;
            
            ans += (n - R + 1);

            if (--freq[nums[L]] == 0) {
                freq.erase(nums[L]);
                --distinctInWindow;
            }
            ++L;
        }
        
        return (int)ans;
    }
};
