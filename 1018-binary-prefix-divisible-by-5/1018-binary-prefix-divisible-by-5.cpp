class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        vector<bool> ans;
        for(auto it : nums){
            if(it == 0) ans.push_back(true);
            else ans.push_back(false);
        }
        return ans;
    }
};