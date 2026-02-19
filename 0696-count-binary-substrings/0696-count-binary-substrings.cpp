class Solution {
public:
    int countBinarySubstrings(string s) {
        int prev = 0;
        int ans = 0;
        char last = s[0];
        int cnt = 0;
        for(int i = 0; i < s.size(); i++){
            if(last == s[i]){
                cnt++;
            }
            else{
                ans += min(cnt, prev);
                prev = cnt;
                last = s[i];
                cnt = 1;
            }
        }
        ans += min(cnt, prev);
        return ans;
    }
};