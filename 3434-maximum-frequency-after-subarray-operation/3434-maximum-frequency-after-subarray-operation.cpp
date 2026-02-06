class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        unordered_map<int,int> mp;
        int cnt = 0;
        int bruhh = 0;
        int ans = 0;

        for(auto x : nums) {
            if(x == k){
                cnt++;
            }
            else{
                int curr = mp[x] - cnt;
                curr = max(1, curr + 1);
                mp[x] = curr + cnt;
                ans = max(ans, curr);
            }
        }
        return cnt + ans;
    }
};
