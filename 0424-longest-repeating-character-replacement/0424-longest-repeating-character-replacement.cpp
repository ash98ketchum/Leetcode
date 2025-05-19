class Solution {
public:
    int characterReplacement(string s, int k) {
        map<char, int> mp;
        int start = 0;
        int end = 0;
        int maxx = 0;
        int ans = 0;
        while(end < s.length()){
            mp[s[end]]++;
            maxx = max(maxx, mp[s[end]]);

            while(start <= end && end - start + 1 - maxx > k){
                mp[s[start]]--;
                start++;
            }
            ans = max(ans, end - start + 1);
            end++;
        }
        return ans;
    }

};