class Solution {
public:
    const int MOD = 1e9 + 7;
    vector<vector<long long>> mul(const vector<vector<long long>>&A, const vector<vector<long long>>&B, int n){
        vector<vector<long long>> C(n, vector<long long>(n));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    C[i][j] = (C[i][j] + (A[i][k] * B[k][j]) % MOD) % MOD;
                }
            }
        }
        return C;
        
    }
    vector<long long> apply(const vector<vector<long long>> &m, const vector<long long> &v, int n){
        vector<long long> res(n);
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n; j++){
                res[i] = (res[i] + (m[i][j] * v[j]) % MOD) % MOD;
            }
        }
        return res;
        
    }
    vector<vector<long long>> power(vector<vector<long long>>&m, long long exp, int n){
        vector<vector<long long>> res(n, vector<long long>(n));
        for(int i = 0; i < n; i++) res[i][i] = 1;

        while(exp > 0 ){
            if(exp % 2 == 1) res = mul(res, m, n);
            m = mul(m, m, n);
            exp >>= 1;
        }
        return res;
    }
    int zigZagArrays(int n, int l, int r) {
        if(n < 2) return 0;
        int len = r - l + 1;
        int size = 2 * len;
        if(n == 2) return (len * (len - 1)) % MOD;

        vector<long long> st(size);
        for(int i = l; i <= r; i++){
            int idx = i - l;
            st[idx] = i - l;
            st[idx + len] = r - i;
        }
        vector<vector<long long>> trans(size, vector<long long>(size));
        for(int i = l; i <=r; i++){
            int idx = i - l;
            for(int j = l; j <i;j++) trans[idx][len + (j - l)] = 1;
            for(int j = i + 1; j <= r; j++) trans[len + idx][j - l] = 1;
        }

        vector<vector<long long>> nT = power(trans, n - 2, size);
        auto res = apply(nT, st, size);

        long long ans = 0;
        for(auto x : res) ans = (ans + x) % MOD;
        return ans;
        
    }
};