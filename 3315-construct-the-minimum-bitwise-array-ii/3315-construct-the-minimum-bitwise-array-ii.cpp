class Solution {
public:
    vector<int> minBitwiseArray(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n, -1);

        for (int i = 0; i < n; i++) {
            int y = nums[i];
            if ((y & 1) == 0) continue;
            int k = __builtin_ctz(~y);
            int x = y - (1 << (k - 1));
            res[i] = x;
        }
        return res;
    }
};
