class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int n = board.size();
        int m = board[0].size();
        vector<vector<int>> ans(n, vector<int>(m, 0));

        int dx[] = {1, 1, 1, 0, 0, -1, -1, -1};
        int dy[] = {-1, 1, 0, 1, -1, 0, -1, 1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int cnt1 = 0;
                for(int k = 0; k < 8; k++){
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if(ni >= 0 && nj >= 0 && ni < n && nj < m && board[ni][nj] == 1){
                        cnt1++;
                    }
                }

                if(board[i][j] == 1){
                    if(cnt1 >3 || cnt1 < 2) ans[i][j] = 0;
                    if(cnt1 == 2 || cnt1 == 3) ans[i][j] = 1;
                }
                else{
                    if(cnt1 == 3) ans[i][j] = 1;
                }

            }
        }
        board = ans;
    }
};