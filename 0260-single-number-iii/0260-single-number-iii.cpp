class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int xr = 0;
        for(auto it : nums) xr ^= it;
        int b = 0;
        while((xr & 1) == 0){
            b++;
            xr /= 2;
        }
        int x = 0;
        int y = 0;
        int mask = (1 << b);
        for(auto it : nums){
            if((it & mask) == 0) x ^= it;
            else y ^= it;
        }
        vector<int> ans = {x, y};
        return ans;
    }
};