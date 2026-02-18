class Solution {
public:
    bool hasAlternatingBits(int n) {
        int f = -1;
        while(n > 0){
            int c = n & 1;
            if(f == c) return false;
            n >>= 1;
            f = c;
        }
        return true;
    }
};