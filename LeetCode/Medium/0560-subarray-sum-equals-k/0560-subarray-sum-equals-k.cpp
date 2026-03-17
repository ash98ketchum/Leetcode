class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        map<int, int> mp;
        mp[0] = 1;
        int cnt = 0;
        int sum = 0;
        for(auto it : nums){
            sum += it;
            if(mp.find(sum - k) != mp.end()){
                cnt += mp[sum - k];
            }
            mp[sum]++;
        }
        return cnt;
    }
};