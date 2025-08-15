class Solution {
public:
    bool isPowerOfFour(int n) {
        
        if (n <= 0) return false;
        if ((n & (n - 1)) != 0) return false;
        int cnt = __builtin_ctz(n);
        return (cnt % 2 == 0);
    }
};