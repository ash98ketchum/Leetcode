class Solution {
public:
    int rec(int i, int j,string &s, vector<vector<int>>&dp){
        // base case
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ways1=0,ways2=1e9;
        ways1=1+rec(i+1,j,s,dp);
        for(int k=i+1;k<=j;k++){
            if(s[i]==s[k]){
              // transition;  
              ways2=min(ways2,rec(i+1,k-1,s,dp) + rec(k,j,s,dp));
            }
        }
        return dp[i][j]=min(ways1,ways2);
    }
    int strangePrinter(string s) {
        // map<char,int>mp;
        // int n=s.size();
        // for(int i=0;i<n;i++){
        //     mp[s[i]]++;
        // }
        // int ans=mp.size();
        // return ans;
        
        int n=s.size();
        // state--> i,times dp[i][times]        
        vector<vector<int>>dp(n+1,vector<int>(n+1,-1));
        return rec(0,n-1,s,dp);
        
        
    }
};