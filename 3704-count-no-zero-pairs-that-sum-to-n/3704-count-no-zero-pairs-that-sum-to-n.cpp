class Solution {
public:
    long long countNoZeroPairs(long long n) {
        if(n < 10) return n - 1;
        return hasZero(n) ? helper(n) : helper(n) - 2;
    }

    long long helper(long long n) {
        if(n < 10) return n + 1;
        long long cnt1 = n % 10 == 0 ? 0 : (n % 10 - 1LL) * helper(n / 10);
        long long cnt2 = (9LL - n % 10) * helper(n / 10 - 1);
        return hasZero(n) ? cnt1 + cnt2 : cnt1 + cnt2 + 2;
    }

    bool hasZero(long long n){
        while(n > 0){
            if(n % 10 == 0) return 1;
            n /= 10;
        }
        return 0;
    }
};