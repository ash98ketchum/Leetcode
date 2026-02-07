class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<vector<int>, vector<string>> grped;

        for(string s : strs){
            vector<int> freq(26, 0);
            for(char ch : s){
                freq[ch - 'a']++;
            }
            grped[freq].push_back(s);
        }
        vector<vector<string>> ans;
        for(auto it : grped){
            ans.push_back(it.second);
        }
        return ans;
    }
};