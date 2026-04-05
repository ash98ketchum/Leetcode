class Solution {
public:
    int myrec(vector<int> &cost, int start, int end, int k){
        if(k == 0) return 0;
        int len = end - start;
        if(k > (len + 1)/2) return 1e9;

        vector<vector<int>> dp(len + 1, vector<int>(k + 1, 1e9));
        for(int i = 0; i <= len; i++) dp[i][0] = 0;

        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= k; j++){
                int notake = dp[i - 1][j];
                int prev;
                if(i >= 2) prev = dp[i - 2][j - 1];
                else prev = dp[0][j - 1];

                int take;
                if(prev != 1e9) take  = prev + cost[start + i - 1];
                else take = 1e9;
                dp[i][j] = min(take, notake);
            }
        }
        return dp[len][k];
    }
    int minOperations(vector<int>& nums, int k) {
        if(k == 0) return 0;
        int n = nums.size();
        if(k > n/2) return -1;

        vector<int> cost(n);
        for(int i = 0; i < n; i++){
            int l = nums[(i - 1 + n) % n];
            int r = nums[(i + 1) % n];
            cost[i] = max(0, max(l, r) + 1 - nums[i]);
        }

        int ans1 = myrec(cost, 1, n, k);
        int ans2 = myrec(cost, 0, n - 1, k);
        int res = min(ans1, ans2);
        if(res >= 1e9) return -1;
        else return res;
    }
};