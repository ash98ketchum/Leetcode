class Solution {
public:
    int myfun(int a) {
        int cnt = 0;
        while (a > 0) {
            if (a & 1) cnt++;
            a >>= 1;
        }
        return cnt;
    }

    vector<int> sortByBits(vector<int>& arr) {
        sort(arr.begin(), arr.end(), [&](int a, int b) {
            int countA = myfun(a);
            int countB = myfun(b);
            
            if (countA != countB) {
                return countA < countB;
            }
            return a < b;
        });
        return arr;
    }
};