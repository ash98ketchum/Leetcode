class Solution {
public:
    int myrec(int idx, vector<int> &arr, int target, vector<vector<int>> &dp){
        if(idx < 0) return 1e9;
        if(target == 0) return 0;
        if(dp[idx][target] != -1) return dp[idx][target];
        int t = 1e9;
        if((target - arr[idx]) >= 0){
            int v = myrec(idx, arr, target - arr[idx], dp);
            if(v < 1e9){
                t = v + 1;
            }
        }
        int nt = myrec(idx - 1, arr, target, dp);
        return dp[idx][target] = min(t, nt);
    }
    int minimumNumbers(int num, int k) {
        if(num == 0) return 0;
        // if(k == 0) return -1;
        vector<int> arr;
        int val = k;
        while(val <= num){
            if(val != 0) arr.push_back(val);
            val += 10;
        }
        vector<vector<int>> dp(arr.size() + 1, vector<int>(val + 1, -1));
        int ans = myrec(arr.size() - 1, arr, num, dp);
        if(ans >= 1e9) return -1;
        return ans;

    }
};