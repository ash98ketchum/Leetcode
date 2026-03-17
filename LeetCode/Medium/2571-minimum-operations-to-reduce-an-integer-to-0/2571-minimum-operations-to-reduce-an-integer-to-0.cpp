class Solution {
public:
    int minOperations(int n) {
        int steps = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else{
                if (n == 1) {
                    steps++;
                    break;
                }
                if ((n & 3) == 3) {
                    n += 1;
                } else {
                    n -= 1;
                }
                steps++;
            }
        }

        return steps;
    }
};