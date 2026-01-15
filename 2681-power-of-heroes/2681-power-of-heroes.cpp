class Solution {
public:
    int sumOfPower(vector<int>& nums) {
        long long MOD = 1e9 + 7;
        sort(nums.begin(), nums.end());
        int n = nums.size();
        long long prev = (1LL * nums[n - 1] * nums[n - 1]) % MOD;
        long long ans = (prev * nums[n - 1]) % MOD;
        
        for(int i = n - 2; i >= 0; i--){
            ans = (ans + (prev * nums[i]) % MOD) % MOD;
            long long square = (1LL * nums[i] * nums[i]) % MOD;
            ans = (ans + (nums[i] * square) % MOD) % MOD;
            prev = (2 * prev + square) % MOD;
        }
        return ans;
    }
};