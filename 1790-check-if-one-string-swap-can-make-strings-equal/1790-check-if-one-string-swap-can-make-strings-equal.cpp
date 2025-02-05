class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        map<char,int> mp,mp1;
        for(auto ch: s1) mp[ch]++;
        for(auto ch: s2) mp1[ch]++;
        if(mp!=mp1) return false;
        else{
            int cnt=0;
            for(int i=0;i<s1.length();i++){
                if(s1[i]!=s2[i]) cnt++;
            }
            if(cnt<=2) return true;
            else return false;
        }
    }
};