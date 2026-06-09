class Solution {
public:
    long long maxTotalValue(vector<int>& nums, int k) {
        long long minn = 1e12;
        long long maxx = -1;
        for(auto it : nums){
            minn = min(minn, (long long)it);
            maxx = max(maxx, (long long)it);
        }
        return 1LL * k * (maxx - minn);

    }
};