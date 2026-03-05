class Solution {
public:
    int minOperations(string s) {
        int op1 = 0;
        for(int i = 0; i < s.size(); i++){
            char ch = (i % 2 == 0) ? '0' : '1';
            if(s[i] != ch) op1++;
        }
        return min(op1, (int)s.size() - op1);
    }
};