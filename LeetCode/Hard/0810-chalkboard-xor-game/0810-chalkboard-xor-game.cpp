class Solution {
public:
    bool xorGame(vector<int>& nums) {
        int val = 0;
        for(auto it : nums) val ^= it;
        return val == 0 || (nums.size() % 2) == 0;
    }
};