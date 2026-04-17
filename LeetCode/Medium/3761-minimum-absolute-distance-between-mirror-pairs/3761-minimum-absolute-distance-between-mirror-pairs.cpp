class Solution {
public:
    int reve(int n){
        int ans = 0;
        while(n > 0){
            ans = ans * 10 + n % 10;
            n/=10;
        }
        return ans;
    }
    int minMirrorPairDistance(vector<int>& nums) {
        map<int, int> mp;
        int dist = 1e9;
        for(int i = 0; i < nums.size(); i++){
            int curr = nums[i];

            if(mp.count(curr)){
                int j = mp[curr];
                int d2 = i - j;
                if(d2 < dist){
                    dist = d2;
                }
                
            }
            int rev = reve(curr);
            mp[rev] = i;
        }
        if(dist == 1e9) return -1;
        return dist;
    }
};