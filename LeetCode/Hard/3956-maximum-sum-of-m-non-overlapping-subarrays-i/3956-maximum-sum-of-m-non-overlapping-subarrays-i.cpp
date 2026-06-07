using ll = long long;
class Solution {
public:
    long long maximumSum(vector<int>& nums, int m, int l, int r) {
        ll n = nums.size();
        vector<ll> pref(n + 1, 0);
        for(int i = 1; i <= n; i++) pref[i] = pref[i - 1] + nums[i - 1];

        vector<ll> dp(n + 1, 0);
        ll ans = -1e18;

        for(int j = 1; j <= m; j++){
            vector<ll> ndp(n + 1, -1e18);
            deque<ll> dq;
            for(int i = 1; i <= n; i++){
                ndp[i] = ndp[i - 1];    //skip;
                ll k = i - l;
                if(k >= 0){
                    while(!dq.empty() && dp[dq.back()] - pref[dq.back()] <= dp[k] - pref[k]){
                        dq.pop_back();
                    }
                    dq.push_back(k);
                }
                while(!dq.empty() && dq.front() < i - r) dq.pop_front();

                if(!dq.empty() && dp[dq.front()] > -1e17){
                    ndp[i] = max(ndp[i], pref[i] + dp[dq.front()] - pref[dq.front()]);
                }
            }
            for(int i = 1; i <= n; i++) ans = max(ans, ndp[i]);
            dp = ndp;
        }
        return ans;


    }
};