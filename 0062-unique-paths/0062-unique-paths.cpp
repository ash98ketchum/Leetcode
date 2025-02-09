class Solution {
public:
    long long comb(int a, int b) {
        if (b > a - b) b = a - b; // Use the smaller value for efficiency
        long long res = 1;
        for (int i = 0; i < b; i++) {
            res = res * (a - i) / (i + 1);
        }
        return res;
    }

    int uniquePaths(int m, int n) {
        return comb(m + n - 2, min(m - 1, n - 1));
    }
};