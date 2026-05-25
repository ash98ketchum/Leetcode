class Solution {
public:
const int MOD = 1e9 + 7;
vector<vector<int>> matmul(vector<vector<int>>&A, vector<vector<int>>&B){
    int n = A.size();
    vector<vector<int>> C(n, vector<int>(n, 0));
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            for(int k = 0; k < n; k++){
                C[i][j] = (C[i][j] + (1LL * A[i][k] * B[k][j]) % MOD) % MOD;
            }
        }
    }
    return C;
}

vector<vector<int>> matexpo(vector<vector<int>> &T, int ex){
    int n = T.size();
    vector<vector<int>> res(n, vector<int>(n, 0));
    for(int i = 0; i < n; i++){
        res[i][i] = 1;
    }
    while(ex > 0){
        if(ex & 1) res = matmul(res, T);
        T = matmul(T, T);
        ex >>= 1;
    }
    return res;
}
    int numTilings(int n) {
       vector<vector<int>> T = {{1, 1, 2}, {1,0,0}, {0,1,1}};
       vector<vector<int>> T_dash = matexpo(T, n - 1);

        vector<vector<int>> S1 = {{1}, {1}, {0}};
       int res = (T_dash[0][0] * S1[0][0] + T_dash[0][1] * S1[1][0] + T_dash[0][2] * S1[2][0]) % MOD;
       return res;
    }
};