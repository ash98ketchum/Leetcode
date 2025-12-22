class Solution {
public:
    struct Node{
        int first;
        int second;
        string str;
        Node(){} : (int)first, (int)second, (string)str;
    };
    string alphabetBoardPath(string target) {
        vector<string> grid = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z...."};
        int n = grid.size();
        int m = grid[0].size();

        int sr = 0, sc = 0;

        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        char move[] = {'L', 'U', 'R', 'D'}
        string ans = "";
        for(auto t : target){
            queue<Node> q;
            q.push({sr,sc,""});

            while(!q.empty()){
                int r = q.front().first;
                int c = q.front().second;
                int str = q.front().str;
                q.pop();
                if(grid[r][c] == t){
                    ans += str;
                    ans += '!';
                    sr = r;
                    sc = c;
                    break;
                }

                for(int i = 0; i < n; i++){
                    int nr = r + dx[i];
                    int nc = c + dy[i];
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                        q.push({nr, nc, str + move[i]});
                    }
                }
            }
        }
        return ans;
    }
};