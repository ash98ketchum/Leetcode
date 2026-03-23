class Solution {
public:
    // unordered_map<string, long long> memo;
    vector<vector<int>> dp;
    // 1 2 5
    // 11 
    // 1 10
    long long myrec(int start, long long sum, vector<int>& coins, int amount){
        //base
        if(sum == amount) return 0;
        if(sum > amount) return 1e9;
        if(start == coins.size()) return 1e9;

        //memoization
        // string hash = to_string(start) + "#" + to_string(sum);
        // if(memo.find(hash) != memo.end()) return memo[hash];
        // cout << dp[start][sum] << endl;
        if(dp[start][sum] != 2e9) return dp[start][sum];

        //calls
        long long take = 1 + myrec(start, sum + coins[start],coins, amount);
        long long notake = myrec(start + 1, sum, coins, amount);
        // cout << min(take, notake) << endl;
        // memo[hash] = min(take, notake);
        dp[start][sum] = min(take, notake);
        return min(take, notake);
    }
    int coinChange(vector<int>& coins, int amount) {
        dp.resize(coins.size(), vector<int>(amount + 1, 2e9));
        long long val = myrec(0, 0, coins, amount);
        
        if(val >= 1e9){
            return -1;
        }
        else{
            return val;
        }
    }
    //recursion -> memoization -> tabulation -> space optimization
};