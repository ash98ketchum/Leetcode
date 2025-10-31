class Solution {
public:
    vector<int> getSneakyNumbers(vector<int>& nums) {
        vector<int> freq(105,0);
        vector<int> ans;
        for(auto it : nums){
            freq[it]++;
            if(freq[it] == 2) ans.push_back(it);
        }
        return ans;
    }
};