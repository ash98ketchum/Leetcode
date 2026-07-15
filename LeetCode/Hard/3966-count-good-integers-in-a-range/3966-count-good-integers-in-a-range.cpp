class Solution {
public:
    typedef long long ll;
    long long rec(int i,bool tight,bool lz,int cs,vector<vector<vector<vector<ll>>>>&dp,string &s, int k){
        if(i==s.size()){
            return 1;
        }
        if(dp[i][tight][lz][cs]!=-1){
            return dp[i][tight][lz][cs];
        }
        int limit = tight?(s[i]-'0'):9;
        long long ans=0;
        for(int d=0;d<=limit;d++){
            bool nt=tight && (d==limit);
            bool nlz=lz && (d==0);
            ll ncs=0;
            // if(nlz){
            //     ans+=rec(i+1,nt,nlz,0,dp,s,k);
            // }
            // else{
            // if(abs(cs-d)<=k || lz){
            //     ans+=rec(i+1,nt,nlz,d,dp,s,k);
            // }
            // }
            
            if(!lz && abs(cs - d) > k) continue;
            if(nlz){
                ncs = 0;
            }
            else ncs = d;
            ans += rec(i + 1, nt, nlz, ncs, dp, s, k);
        }
        return dp[i][tight][lz][cs]=ans;
        
    }
    long long goodIntegers(long long l, long long r, int k) {
        l--;
        string a=to_string(l);
        string b=to_string(r);
        ll len1=a.size();
        ll len2=b.size();
        vector<vector<vector<vector<ll>>>> dp1(len1 + 1, vector<vector<vector<ll>>>(2, vector<vector<ll>>          (2, vector<ll>(18, -1))));
        vector<vector<vector<vector<ll>>>> dp2(len2 + 1, vector<vector<vector<ll>>>(2, vector<vector<ll>>(2, vector<ll>(18, -1))));
        ll ans1=rec(0,1,1,0,dp1,a,k);
        ll ans2=rec(0,1,1,0,dp2,b,k);

        return abs(ans2-ans1);
        
    }
};