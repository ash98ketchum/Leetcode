class Solution {
public:
    int rec(int i, int j, vector<int>&stones, vector<int>&pre ,int k,vector<vector<int>>&dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=1e9;
        for(int a=i;a<j;a+=k-1){
            ans=min(ans,rec(i,a,stones,pre,k,dp) + rec(a + 1, j,stones,pre,k,dp));
        }
        if((j-i)%(k-1) == 0){
            ans+=pre[j+1] - pre[i];
        }
        return dp[i][j]=ans;

    }
    int mergeStones(vector<int>& stones, int k) {
        // states is 2
        int n=stones.size();
        if((n - 1) % (k - 1) != 0) return -1;
        vector<int>pre(n+1,0);
        vector<vector<int>>dp(n+1,vector<int>(n+1,-1));
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + stones[i];
        }
        return rec(0,n-1,stones,pre,k,dp);
    }
};