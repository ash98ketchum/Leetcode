class Solution {
public:
    int numWays(string s) {
        const long long MOD = 1e9 + 7;
        int n =s.size();
        vector<int> pref(n);
        pref[0] = s[0] - '0';
        for(int i = 1; i < n; i++){
            pref[i] = pref[i - 1] + (s[i] - '0');
        }

        int cnt1 = pref[n - 1];
        if(cnt1 == 0) return (((long long)(n - 1) * (n - 2))/2) % MOD;
        if(cnt1 % 3 != 0) return 0;

        // 00000
        // 0 0 000
        // 0 00 00
        // 0 000 0
        // 00 0 00
        // 00 00 0
        // 000 0 0
        long long c1 = 0;
        long long c2 = 0;
        for(auto it : pref){
            if(it == (cnt1/3)) c1++;
            else if(it == (2 * (cnt1/3))) c2++; 
        }
        return (c1  * c2) % MOD;


    }
};