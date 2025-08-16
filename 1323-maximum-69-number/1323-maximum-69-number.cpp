class Solution {
public:
    int maximum69Number (int num) {
        int temp = num;
        int mul = 1;
        int maxx = num;
        while(temp > 0){
            int rem = temp % 10;
            temp /= 10;
            if(rem == 6){
                num -= (rem * mul);
                num += (9 * mul);
                maxx = max(maxx, num);
                num -= (9 * mul);
                num += (rem * mul);
                
            }
            mul *= 10;
        }
        return maxx;
    }
};