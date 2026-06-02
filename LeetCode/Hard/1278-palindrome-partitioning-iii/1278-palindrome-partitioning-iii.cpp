class Solution {
public:
    int rec(string &s, int i, int k, vector<vector<int>> &dp, vector<vector<int>>&cost){
    if(k==1)
       return cost[i][s.size()-1];
    if(i == s.size()) return 1e9;
    if(dp[i][k]!=-1){
        return dp[i][k];
    }
    int ans=1e9;
    for(int j=i;j<=s.size()-k;j++){//
        ans=min(ans,rec(s,j+1,k-1,dp,cost) + cost[i][j]);//
    }
    return dp[i][k]=ans;
}
    int palindromePartition(string s, int k) {
        int n=s.size();
        vector<vector<int>>dp(n+1,vector<int>(n+1,-1));
        vector<vector<int>>cost(n+1,vector<int>(n+1,0));//
        for(int len=2;len<=s.size();len++){
            for(int i=0;i<=s.size()-len;i++){
                int j=i+len-1;
                cost[i][j]=(s[i]!=s[j]) + cost[i+1][j-1];
            }
        }
        return rec(s,0,k, dp, cost);
    }
};