class Solution {
public:
    int countCoveredBuildings(int n, vector<vector<int>>& buildings) {

        unordered_map<int, int> minY, maxY, minX, maxX;

        for (auto &b : buildings) {
            int x = b[0], y = b[1];

            if (!minY.count(x)) minY[x] = y;
            else minY[x] = min(minY[x], y);

            if (!maxY.count(x)) maxY[x] = y;
            else maxY[x] = max(maxY[x], y);

            if (!minX.count(y)) minX[y] = x;
            else minX[y] = min(minX[y], x);

            if (!maxX.count(y)) maxX[y] = x;
            else maxX[y] = max(maxX[y], x);
        }

        int ans = 0;

        for (auto &b : buildings) {
            int x = b[0], y = b[1];

            bool left  = (minY[x] < y);
            bool right = (maxY[x] > y);
            bool down  = (minX[y] < x);
            bool up    = (maxX[y] > x);

            if (left && right && up && down)
                ans++;
        }

        return ans;
    }
};
