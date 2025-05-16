class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        map<int,int> mp;
        bool ans = false;
        
        k++;
        if (k > nums.size()) k = nums.size();
        for (int i = 0; i < k; i++) {
            mp[nums[i]]++;
        }
        
        if(mp.size() < k){
            ans = true;
            return ans;
        }
        int n = nums.size();
        for(int i = k; i < n; i++){
            mp[nums[i]]++;
            if (--mp[nums[i - k]] == 0) {
                mp.erase(nums[i - k]);
            }
            if(mp.size() < k){
                ans = true;
                return ans;
            }
        }
        return ans;
    }
};