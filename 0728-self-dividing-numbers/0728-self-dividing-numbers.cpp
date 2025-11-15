class Solution {
public:
    bool isSelfDividing(int x) {
        int n = x;
        while (n > 0) {
            int d = n % 10;
            if (d == 0 || x % d != 0) return false;
            n /= 10;
        }
        return true;
    }

    vector<int> selfDividingNumbers(int left, int right) {
        vector<int> ans;
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) ans.push_back(i);
        }
        return ans;
    }
};
