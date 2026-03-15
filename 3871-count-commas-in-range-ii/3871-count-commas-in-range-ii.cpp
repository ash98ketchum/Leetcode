class Solution {
public:
    long long countCommas(long long n) {
        long long cnt = 0;
        long long v = 1000;
        while(v <= n){
            cnt += (n - v + 1);
            v *= 1000;
        }
        return cnt;
    }
};