class Solution {
public:
    int numberOfSteps(int num) {
        int c = 0;
        while(num > 0){
            if(num & 1 && num != 1) c+=2;
            else c++;
            num >>= 1;
        }
        return c;
    }
};