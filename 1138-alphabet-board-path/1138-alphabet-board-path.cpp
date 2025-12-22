class Solution {
public:
    struct Node {
        int first;
        int second;
        string str;
        Node(int f, int s, string st) {
            first = f;
            second = s;
            str = st;
        }
    };

    string alphabetBoardPath(string target) {
        vector<string> grid = {
            "abcde",
            "fghij",
            "klmno",
            "pqrst",
            "uvwxy",
            "z...."
        };

        int n = grid.size();
        int m = grid[0].size();

        int sr = 0, sc = 0;
        int dx[] = {0, -1, 0, 1};
        int dy[] = {-1, 0, 1, 0};
        char move[] = {'L', 'U', 'R', 'D'};

        string ans = "";

        for (char t : target) {
            queue<Node> q;
            vector<vector<int>> vis(n, vector<int>(m, 0));

            q.push(Node(sr, sc, ""));
            vis[sr][sc] = 1;

            while (!q.empty()) {
                Node cur = q.front();
                q.pop();

                int r = cur.first;
                int c = cur.second;
                string path = cur.str;

                if (grid[r][c] == t) {
                    ans += path;
                    ans += '!';
                    sr = r;
                    sc = c;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < m &&
                        grid[nr][nc] != '.' && !vis[nr][nc]) {
                        vis[nr][nc] = 1;
                        q.push(Node(nr, nc, path + move[i]));
                    }
                }
            }
        }
        return ans;
    }
};
