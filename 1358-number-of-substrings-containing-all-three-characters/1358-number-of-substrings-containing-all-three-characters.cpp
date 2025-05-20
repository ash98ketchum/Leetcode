class Solution {
public:
    int numberOfSubstrings(string str) {
        int s = 0, e = 0, ans = 0;
        map<char, int> mp;

        while (e < str.length()) {
            // grow
            mp[str[e]]++;

            // shrink
            while (s <= e && mp.size() == 3) {  // you wanted this condition
                ans += str.length() - e;
                if (mp[str[s]] == 1) {
                    mp.erase(str[s]);
                } else {
                    mp[str[s]]--;
                }
                s++;
            }

            // // update ans
            // if (mp.size() == 3) {
            //     ans += 1;
            // }

            e++;
        }
        return ans;
    }
};
