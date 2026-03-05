class Solution {
public:
    int minOperations(string s) {
        int op1 = 0, op2 = 0;
        for(int i = 0; i < s.size(); i++){
            if(i & 1){
                op1 += s[i] == '0' ? 0 : 1;
                op2 += s[i] == '1' ? 0 : 1;
            }
            else{
                op1 += s[i] == '1' ? 0 : 1;
                op2 += s[i] == '0' ? 0 : 1;
            }
        }
        return min(op1, op2);
    }
};