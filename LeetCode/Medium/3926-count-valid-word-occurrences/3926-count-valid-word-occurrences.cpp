class Solution {
public:
    
    bool isLower(char ch){
        return ch >= 'a' && ch <= 'z';
    }

    vector<int> countWordOccurrences(vector<string>& chunks, vector<string>& queries) {
        
        string s = "";
        for(auto &it : chunks) s += it;

        map<string,int> mp;

        string word = "";
        int n = s.size();

        for(int i = 0; i < n; i++){
            if(isLower(s[i])){
                word += s[i];
            }
            else if(s[i] == '-' && i > 0 && i < n - 1 && isLower(s[i-1]) && isLower(s[i+1])){
                word += '-';
            }
            else{
                if(!word.empty()){
                    mp[word]++;
                    word = "";
                }
            }
        }
        if(!word.empty()) mp[word]++;

        vector<int> ans;

        for(auto &q : queries){
            ans.push_back(mp[q]);
        }

        return ans;
    }
};