class Solution {
public:
    string arrangeWords(string text) {
        map<int, vector<string>> mp;
        int i = 0;
        while(i < text.size()){
            if(text[i] == ' '){
                i++;
                continue;
            }
            string s = "";
            while(i < text.size() && text[i] != ' '){
                s += text[i++];
            }
            mp[s.size()].push_back(s);
        }
        string ans = "";
        for(auto it : mp){
            for(auto s : it.second){
                if(ans.size() == 0){
                    ans += toupper(s[0]);
                    ans += s.substr(1, s.size());
                }
                else{
                    ans += tolower(s[0]);
                    ans += s.substr(1, s.size());
                }
                ans += ' ';
            }
        }
        return ans.substr(0,ans.size() - 1);
    }
};