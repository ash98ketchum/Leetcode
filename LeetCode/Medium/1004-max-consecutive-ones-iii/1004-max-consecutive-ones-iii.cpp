class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int start = 0;
        int end = 0;
        int z = 0;
        int ans = 0;
        while(end < nums.size()){
            if(nums[end] == 0) z++;
            while(z > k){
                if(nums[start] == 0) z--;
                start++;
            }
            ans = max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
};