class Solution {
public:
    int minOperations(vector<int>& nums){
        int n = nums.size();
        int num1 = 0;
        int g = 0;
        for (int x : nums) {
            if (x == 1) {
                num1++;
            }
            g = gcd(g, x);
        }
        if (num1 > 0) {
            return n - num1;
        }
        if (g > 1) {
            return -1;
        }
        int x = 0, y = 1e9;
        for(int i = 0; i < n; i++){
            int g = 0;
            for(int j = i; j < n; j++){
                g = __gcd(g, nums[j]);
                if((j - i) < (y - x) && g == 1){
                    x = i;
                    y = j;
                }
            }
        }
        return n + (y - x +1) - 2;
    }
};