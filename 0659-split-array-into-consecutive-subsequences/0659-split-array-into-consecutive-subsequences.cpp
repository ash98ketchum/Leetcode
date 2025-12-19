class Solution {
public:
    bool isPossible(vector<int>& nums) {
        map<int, int> cnt, mp;
        for(auto it : nums) cnt[it]++;

        for(auto it : nums){
            if(cnt[it] == 0) continue;
            if(mp[it - 1] > 0){
                mp[it - 1]--;
                mp[it]++;
            }
            else if(cnt[it + 1] > 0 && cnt[it + 2] > 0){
                cnt[it + 1]--;
                cnt[it + 2]--;
                mp[it + 2]++;
            }
            else return false;
            cnt[it]--;
        }
        return true;
    }
};