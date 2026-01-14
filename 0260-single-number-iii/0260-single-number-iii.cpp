class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int xr = 0;
        for(auto it : nums) xr ^= it;
        //1001000 , 
        int x = 0;
        int y = 0;
        unsigned int ux = (unsigned int)xr;
        unsigned int mask = ux & (-ux);
        for(auto it : nums){
            if((it & mask) == 0) x ^= it;
            else y ^= it;
        }
        return {x, y};
    }
};