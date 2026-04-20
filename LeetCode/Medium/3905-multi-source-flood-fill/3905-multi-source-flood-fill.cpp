class Solution {
public:
    vector<vector<int>> colorGrid(int n, int m, vector<vector<int>>& sources) {
        queue<pair<pair<int, int>, int>> q;
        sort(sources.begin(), sources.end(), [](auto &a, auto &b){
            return b[2] < a[2];
        });
        vector<vector<int>> grid(n, vector<int>(m, 0));
        for(auto it : sources){
            q.push({{it[0], it[1]}, it[2]});
            grid[it[0]][it[1]] = it[2];
        }

        int dx[] = {0,0,-1,1};
        int dy[] = {1,-1,0,0};
        while(!q.empty()){
            int r = q.front().first.first;
            int c = q.front().first.second;
            int col = q.front().second;
            q.pop();

            for(int i = 0; i < 4; i++){
                int nr = r + dx[i];
                int nc = c + dy[i];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 0){
                    grid[nr][nc] = col;
                    q.push({{nr, nc}, col});
                }
            }
        }
        return grid;
    }
};