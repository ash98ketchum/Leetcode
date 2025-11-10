class Solution {
public:
    int minimumDistance(vector<int>& nums) {
        map<int, vector<int>> mp;
        for(int i = 0; i < nums.size(); i++){
            mp[nums[i]].push_back(i);
        }
        int ans = 1e9;
        for(auto it : mp){
            if(it.second.size() >= 3){
                for(int i = 2; i < it.second.size(); i++){
                    ans = min(ans, abs(it.second[i] - it.second[i- 1]) + abs(it.second[i - 1] - it.second[i - 2]) + abs(it.second[i] - it.second[i - 2]));
                }
            }
        }
        if(ans == 1e9) return -1;
        else return ans;
    }
};