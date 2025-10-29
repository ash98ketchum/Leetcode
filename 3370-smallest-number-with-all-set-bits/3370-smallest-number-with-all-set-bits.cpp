class Solution {
public:
    int smallestNumber(int n) {
        int x = 0;
        int i = 0;
        while(n){
            x += (1 << i);
            i++;
            n >>= 1;
        }
        return x;
    }
};