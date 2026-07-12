class Solution {
public:
const int mod = 1e9 + 7;
const int inv = 500000004;
    int minimumCost(vector<int>& nums, int k) {
        long long totalops = 0;
        int curr = k;
        for(auto it: nums){
            if(curr >= it){
                curr -= it;
            }else{   
                int rem = it - curr;
                int op2 = (rem + k - 1)/k;
                totalops += op2;
                curr = abs(rem - op2 * k);
                
            }
        }
        long long ans = (((totalops % mod) * ((totalops + 1) % mod)) % mod * inv) % mod;
        ans %= mod;
        return (int)ans;
    }
};