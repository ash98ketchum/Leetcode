class Solution {
public:
    int numSteps(string s) {
        int n = s.size();

        int ops = 0;
        int carry = 0;
        for (int i = n - 1; i > 0; i--) {
            if (((s[i] - '0') + carry) % 2) {
                ops += 2;
                carry = 1;
            }
            else{
                ops++;
            }
        }

        return ops + carry;
    }
};