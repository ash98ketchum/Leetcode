class Solution {
public:
    bool rec(int i, int prev, map<string, bool>&dp, map<int, int>&mp, vector<int>&stones){
        int n=stones.size();
        if(i==n-1){
            return true;
        }
        if(i>n){
            return false;
        }
        string hash = to_string(i) + "#" + to_string(prev);
        if(dp.find(hash) != dp.end()){
            return dp[hash];
        }
        int pick1=0;
        for(int a=-1;a<=1;a++){
            int jump = prev + a;
            if(jump <= 0) continue;
            if(mp.find(stones[i] + jump) == mp.end()) continue;
            pick1=rec(mp[stones[i]+jump],jump,dp,mp,stones);
            dp[hash]=pick1;
            if(dp[hash]==1){
                return true;
            }
        }
        return dp[hash]=0;
    }
    bool canCross(vector<int>& stones) {
        // what is changing
        // i, prev 
        // pick1,pick2,pick3
        
        int n=stones.size();
        map<int, int> mp;
        for(int i = 0; i < n; i++){
            mp[stones[i]] = i;
        }
        map<string, bool> dp;
        return rec(0,0,dp,mp,stones);
    }
};