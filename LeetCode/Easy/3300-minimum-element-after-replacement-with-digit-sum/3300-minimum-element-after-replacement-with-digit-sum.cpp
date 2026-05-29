class Solution {
public:
    int minElement(vector<int>& nums) {

        
        int ans = 40;
        for(int it : nums){
            int sum = 0;
            while(it > 0){
                sum += (it % 10);
                it /= 10;
            }
            ans = min(ans, sum);
        }
        return ans;
    }
};