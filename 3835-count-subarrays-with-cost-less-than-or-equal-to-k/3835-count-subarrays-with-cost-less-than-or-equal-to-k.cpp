using ll = long long;

class Solution {
public:
    ll countSubarrays(vector<int>& nums, ll k) {
        ll start = 0;
        ll end = 0;
        ll n = nums.size();
        ll cnt = 0;
        map<int, int> mp;
        
        while(end < n){
            mp[nums[end]]++;
            while(start <= end) {
                ll maxx = mp.rbegin()->first;
                ll minn = mp.begin()->first;
                ll cost = (maxx - minn) * (end - start + 1);
                
                if(cost > k){
                    mp[nums[start]]--;
                    if(mp[nums[start]] == 0) mp.erase(nums[start]);
                    start++;
                } 
                else{
                    break;
                }
            }
            cnt += (end - start + 1);
            end++;
        }
        return cnt;
    }
};