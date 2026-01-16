class Solution {
public:
    int countHousePlacements(int n) {
        long long MOD = 1e9 + 7;
        int f1 = 2;
        if(n == 1) return f1 * f1;
        int f2 = 3;
        if(n == 2) return f2 * f2;
        long long temp = 0;
        for(int i = 3; i <= n; i++){
            temp = (f1 + f2) % MOD;
            f1 = f2;
            f2 = temp;
        }
        return (temp * temp) % MOD;
    }
};