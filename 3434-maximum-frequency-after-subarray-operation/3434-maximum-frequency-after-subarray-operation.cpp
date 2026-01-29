class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        unordered_map<int,int> gain;
        int cnt = 0;
        int bruhh = 0;
        int ans = 0;

        for(auto x : nums) {
            if(x == k){
                cnt++;
                bruhh++;
            }
            else{
                int curr = gain[x] - bruhh;
                curr = max(1, curr + 1);
                gain[x] = curr + bruhh;
                ans = max(ans, curr);
            }
        }
        return cnt + ans;
    }
};
