class Solution {
    vector<int> index;
    bool path[16];
    long long dp[16][10][2];
    string str;
    long long myrec(int pos, int last, bool bound) {
        if(pos == 16) return 1; 

        if(dp[pos][last][bound] != -1) {
            return dp[pos][last][bound];
        }

        int limit = bound ? (str[pos] - '0') : 9;
        long long ways = 0;

        for (int d = 0; d <= limit; d++) {
            if(path[pos]){
                if (d >= last) {
                    ways += myrec(pos + 1, d, bound && (d == limit));
                }
            }
            else{
                ways += myrec(pos + 1, last, bound && (d == limit));
            }
        }

        return dp[pos][last][bound] = ways;
    }

public:
    long long myfunc(long long n) {
        str = to_string(n);
        str.insert(0, 16 - str.length(), '0');
        memset(dp, -1, sizeof(dp));
        return myrec(0, 0, true);
    }

    long long countGoodIntegersOnPath(long long l, long long r, string directions) {
        int row = 0, col = 0;

        index.clear();
        index.push_back(0);
        for(auto it : directions){
            if(it == 'D') row++;
            else col++;
            index.push_back(4 * row + col);
        }
        memset(path, false, sizeof(path));
        for(int idx : index) {
            path[idx] = true;
        }

        return myfunc(r) - myfunc(l - 1);
    }
};