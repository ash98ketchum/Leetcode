class Solution {
public:
    int countCommas(int n) {
        int cnt = 0;
        int v = 1000;
        while(v <= n){
            cnt += (n - v + 1);
            v *= 1000;
        }
        return cnt;
    }
};