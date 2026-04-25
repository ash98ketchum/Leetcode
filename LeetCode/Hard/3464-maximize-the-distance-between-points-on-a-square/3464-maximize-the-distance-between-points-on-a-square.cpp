class Solution {
public:
    bool can(vector<long long>& a, int k, long long d, long long perimeter) {
        int n = a.size();
        vector<long long> b = a;
        for(auto x : a) b.push_back(x + perimeter);

        int m = b.size();
        vector<int> nxt(m);
        int j = 0;

        for(int i = 0; i < m; i++) {
            while(j < m && b[j] - b[i] < d) {
                j++;
            }
            nxt[i] = j;
        }
        for(int i = 0; i < n; i++) {
            int curr = i;
            for(int step = 1; step < k; step++) {
                curr = nxt[curr];
                if(curr >= m) break;
            }
            if(curr < m && (b[i] + perimeter) - b[curr] >= d) {
                return true; 
            }
        }
        
        return false;
    }

    int maxDistance(int side, vector<vector<int>>& points, int k) {
        vector<long long> a;
        for(auto &p : points) {
            int x = p[0], y = p[1];

            if(y == 0) a.push_back(x);
            else if(x == side) a.push_back(side + y);
            else if(y == side) a.push_back(2LL * side + (side - x));
            else a.push_back(3LL * side + (side - y));
        }

        sort(a.begin(), a.end());

        long long perimeter = 4LL * side;
        long long low = 1, high = side, ans = 0;

        while(low <= high) {
            long long mid = low + (high - low) / 2;

            if(can(a, k, mid, perimeter)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
};