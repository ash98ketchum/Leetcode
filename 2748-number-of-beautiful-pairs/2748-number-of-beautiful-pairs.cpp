class Solution {
public:
    int firstDigit(int x) {
        while (x >= 10) x /= 10;
        return x;
    }
    
    int lastDigit(int x) {
        return x % 10;
    }
    
    int countBeautifulPairs(vector<int>& nums) {
        vector<int> freq(10, 0);
        int ans = 0;
        
        for (int j = 0; j < nums.size(); j++) {
            int ld = lastDigit(nums[j]);
            for (int d = 1; d <= 9; d++) {
                if (freq[d] > 0 && gcd(d, ld) == 1) {
                    ans += freq[d];
                }
            }
            
            int fd = firstDigit(nums[j]);
            freq[fd]++;
        }
        
        return ans;
    }
};
