class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        int cnt = 0;
        for(int it : nums){
            if(it % 3 != 0) cnt++;
        }
        return cnt;
    }
};