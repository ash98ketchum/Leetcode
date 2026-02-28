class Solution {
public:
    int concatenatedBinary(int n) {
        int shifter = 1;
        int val = 1;
        long long answer = 0;
        int mod = 1'000'000'007;
        
        for(int a = 1; a <= n; a++){
            if(val * 2 == a){
                shifter++;
                val = a;
            }
            answer = ((answer << shifter) | a) % mod;
        }
        
        return answer;
    }
};