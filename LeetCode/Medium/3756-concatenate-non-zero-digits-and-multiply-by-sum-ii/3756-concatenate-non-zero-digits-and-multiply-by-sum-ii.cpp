class Solution {
public:
    long long MOD = 1e9 + 7;
    long long modpow(long long b, long long ex){
        long long res = 1;
        b %= MOD;
        while(ex > 0){
            if(ex %2 == 1) res = (res * b) % MOD;
            b = (b * b) % MOD;
            ex /= 2;
        }
        return res;
    }
    long long modinv(long long n){
        return modpow(n, MOD - 2);
    }
    vector<int> sumAndMultiply(string s, vector<vector<int>>& queries) {
        int n = s.length();
        vector<long long> p10(n + 1);
        vector<long long> invp10(n + 1);
        p10[0] = 1;
        invp10[0] = 1;
        long long inv10 = modinv(10);
        for(int i = 1; i <= n; i++){
            p10[i] = (p10[i - 1] * 10)% MOD;
            invp10[i] = (invp10[i - 1] * inv10) % MOD;
        }

        vector<int> cnt(n);
        vector<long long> digsum(n);
        vector<long long> sum(n);

        int currcnt = 0;
        long long currd = 0;
        long long currs = 0;
        for(int i = 0; i < n; i++){
            int d = s[i] - '0';
            if(d != 0) currcnt++;
            currd += d;
            if(d != 0){
                long long x = (d * invp10[currcnt]) % MOD;
                currs = (currs + x) % MOD;
            }
            cnt[i] = currcnt;
            digsum[i] = currd;
            sum[i] = currs;
            
        }
        vector<int> res(queries.size());
        int idx = 0;
        for(auto it : queries){
            int l = it[0];
            int r = it[1];
            long long sumval = digsum[r];
            if(l > 0) sumval -= digsum[l - 1];

            long long rangesum = sum[r];
            if(l > 0) rangesum = (rangesum - sum[l - 1] + MOD) % MOD;
            long long x = (rangesum *p10[cnt[r]]) % MOD;
            long long ans = (x * (sumval %  MOD)) % MOD;
            res[idx++] = ans;
        }
        return res;
        
            
    }
};