class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        map<int, int> mp;
        int ans = 0;
        for(auto it : nums){
            mp[it]++;
            ans = max(ans, mp[it]);
        }
        int sum = 0;
        for(auto p : mp){
            if(p.second == ans) sum += p.second;
        }
        return sum;
    }
};