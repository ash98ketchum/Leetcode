class Solution {
public:
    const int m = 1e9+7;
    int dp[101][101][101];

    int solve(string &w1,string &w2,string &target,int i,int j,int k){
        if(k == target.size() && i>0 && j>0) return 1;

        if(dp[i][j][k] != -1) return dp[i][j][k];

        int ans = 0;
        for(int p=i; p<w1.size(); p++){
            if(w1[p] == target[k])
                ans = (ans + solve(w1,w2,target,p+1,j,k+1)) % m;
        }
        for(int p=j; p<w2.size(); p++){
            if(w2[p] == target[k])
                ans = (ans + solve(w1,w2,target,i,p+1,k+1)) % m;
        }

        return dp[i][j][k] = ans;
    }

    int interleaveCharacters(string w1, string w2, string target) {
        memset(dp,-1,sizeof(dp));
        return solve(w1,w2,target,0,0,0);
    }
};