class Solution {
public:
    long long minEnergy(int n, int brightness, vector<vector<int>>& intervals) {
        // 1  - 1 - 1
        // 10 - 2 - 1
        // 010 - 3 - 1
        // 0101 - 4 - 2
        // 01001 - 5 - 2
        // 010010 - 6 - 2
        // 0100101 - 7 - 3
        // 01001001 - 8 - 3
        // 010010010 - 9 - 3
        // 0100100101 - 10 - 4
        long long need = (brightness + 2) / 3;
        long long ans = 0;

        sort(intervals.begin(), intervals.end());

        int l = intervals[0][0];
        int r = intervals[0][1];

        for(int i = 1; i < intervals.size(); i++) {
            if(intervals[i][0] <= r) {
                r = max(r, intervals[i][1]);
            }
            else{
                long long len = r - l + 1;
                ans += (need * len);

                l = intervals[i][0];
                r = intervals[i][1];
            }
        }

        long long len = r - l + 1;
        ans += (len * need);

        return ans;

    }
};