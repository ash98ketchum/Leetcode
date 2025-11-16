class Solution {
public:
    int numSub(string s) {
        const long long MOD = 1e9+7;
        long long ans = 0;
        long long c1 = 0;

        for(char it : s){
            if(it == '1') c1++;
            else{
                ans = (ans + c1 * (c1 + 1) / 2) % MOD;
                c1 = 0;
            }
        }
        ans = (ans + c1 * (c1 + 1) / 2) % MOD;
        return ans;
    }
};
