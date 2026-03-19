class Solution {
public:
    string makeLargestSpecial(string s) {
        vector<string> v;
        int cnt = 0, start = 0;
        for(int i = 0; i < s.size(); i++){
            if(s[i] == '1') cnt++;
            else cnt--;
            if(cnt == 0){
                string s1 = s.substr(start + 1, i - start - 1);
                string s2 = makeLargestSpecial(s1);
                v.push_back("1" + s2 + "0");
                start = i + 1;
            }
            
        }
        sort(v.rbegin(), v.rend());
        string ans = "";
        for(auto it : v) ans += it;
        return ans;
        
        
    }
};