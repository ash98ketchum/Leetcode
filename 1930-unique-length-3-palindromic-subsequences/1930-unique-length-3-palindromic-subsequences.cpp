class Solution {
public:
    int countPalindromicSubsequence(string s) {
        map<char, pair<int, int>> mp;
        for (int i = 0; i < s.size(); i++) {
            if(mp.find(s[i]) == mp.end()){
                mp[s[i]] = {i, i};
            } 
            else{
                mp[s[i]].first  = min(mp[s[i]].first,  i);
                mp[s[i]].second = max(mp[s[i]].second, i);
            }
        }
        int ans = 0;
        for(auto it : mp){
            int l = it.second.first;
            int r = it.second.second;
            set<char> st;
            for(int i = l + 1; i < r; i++){
                st.insert(s[i]);
            }
            ans += st.size();
        }
        return ans;
    }
};