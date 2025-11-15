class Solution {
public:
    int numberOfSubstrings(string s) {
        int n = s.size();
        if (n == 0) return 0;

        long long cnt = 0;
        long long ones = 0;

        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                ones++;
            } else {
                cnt += (ones * (ones + 1)) / 2;
                ones = 0;
            }
        }
        cnt += (ones * (ones + 1)) / 2;

        vector<int> z;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                z.push_back(i);
            }
        }

        int zn = z.size();
        if (zn == 0) {
            return cnt;
        }

        int B = (int)sqrt(n) + 1;
        int zi = 0;

        for (int i = 0; i < n; i++) {
            while (zi < zn && z[zi] < i) {
                zi++;
            }

            for (int k = 1; k <= B; k++) {
                int ki = zi + k - 1;

                if (ki >= zn) {
                    break;
                }

                long long js = z[ki];
                int nki = zi + k;
                long long je = (nki >= zn) ? (n - 1) : (z[nki] - 1);

                long long mj = (long long)k * k + (long long)k + i - 1;
                long long es = max(js, mj);

                if (es <= je) {
                    cnt += (je - es + 1);
                }
            }
        }
        
        return (int)cnt;
    }
};