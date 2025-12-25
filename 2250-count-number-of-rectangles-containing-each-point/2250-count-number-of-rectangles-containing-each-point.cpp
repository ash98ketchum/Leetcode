class Solution {
public:
    vector<int> countRectangles(vector<vector<int>>& rectangles, vector<vector<int>>& points) {
        vector<vector<int>> heightMap(101);

        for (auto &r : rectangles) {
            heightMap[r[1]].push_back(r[0]);
        }

        for (int h = 1; h <= 100; h++) {
            sort(heightMap[h].begin(), heightMap[h].end());
        }

        vector<int> ans;

        for (auto &p : points) {
            int x = p[0], y = p[1];
            int count = 0;
            for (int h = y; h <= 100; h++) {
                auto &vec = heightMap[h];
                if (vec.empty()) continue;
                auto it = lower_bound(vec.begin(), vec.end(), x);
                count += (vec.end() - it);
            }

            ans.push_back(count);
        }

        return ans;
    }
};
