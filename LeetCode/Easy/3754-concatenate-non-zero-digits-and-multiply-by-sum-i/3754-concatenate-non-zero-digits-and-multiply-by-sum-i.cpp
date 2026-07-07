class Solution {
public:
    long long sumAndMultiply(int n) {
        long long mul = 1;
        long long sum = 0;
        long long num = 0;
        while(n > 0){
            int rem = n % 10;
            if(rem != 0){
                num += (mul * rem);
                mul *= 10;
            }
            n/= 10;
            sum += rem;
        }
        return sum * num;
    }
};