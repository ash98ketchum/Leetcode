class Solution {
public:
    int maxValidPairSum(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> suff(n);
        suff[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) suff[i] = max(suff[i + 1], nums[i]);
        int ans = 0;
        int pref = 0;
        for(int i = 0; i < n; i++){
            pref = max(pref, nums[i]);
            int j = i + k;
            if(j < n){
                ans = max(ans, pref + suff[j]);
            }
        }
        return ans;
    }
};