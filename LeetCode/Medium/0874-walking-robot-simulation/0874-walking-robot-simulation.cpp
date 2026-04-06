class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        unordered_set<string> st;
        for (auto &o : obstacles) {
            st.insert(to_string(o[0]) + "," + to_string(o[1]));
        }
        vector<pair<int,int>> dirs = {
            {0,1}, {1,0}, {0,-1}, {-1,0}
        };

        int dir = 0;
        int x = 0, y = 0;
        int dist = 0;

        for (int cmd : commands) {

            if (cmd == -1) {
                dir = (dir + 1) % 4;
            }
            else if (cmd == -2) {
                dir = (dir + 3) % 4;
            }
            else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[dir].first;
                    int ny = y + dirs[dir].second;
                    string key = to_string(nx) + "," + to_string(ny);
                    if (st.count(key)) break;

                    x = nx;
                    y = ny;

                    dist = max(dist, x*x + y*y);
                }
            }
        }

        return dist;
    }
};