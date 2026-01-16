class Solution {
public:
    int minElements(vector<int>& nums, int limit, int goal) {
        long long sum = accumulate(nums.begin(), nums.end(), 0ll);
        if(sum == goal) return 0;
        else{
            long long tar = abs((long long)goal - sum);
            long long ans = 0;
            if(tar % limit != 0) ans++;
            ans += (tar/limit);
            return ans;
        }
    }
};