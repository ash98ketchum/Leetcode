class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>&grid) {
        int n=grid.size();
       int m=grid[0].size();
       vector<vector<int>>dis(n,vector<int>(m,1e9));
       queue<vector<int>>q;
       //q -> {i, j, time}
       int c=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==0){
                dis[i][j] = 0;
                vector<int> t = {i, j, 0};
                q.push(t);
            }
        }
       }
       
       // 0 -> r
       // 1 - > c
       // 2 -> time
       vector<vector<int>>dx={{-1,0},{1,0},{0,-1},{0,1}};
       while(!q.empty()){
            vector<int> p = q.front();
            q.pop();
            for(auto it:dx){
                int nR=p[0] + it[0];
                int nC=p[1] + it[1];
                int nT = p[2] + 1;
                if(nR>=0 && nR<n && nC>=0 && nC<m && grid[nR][nC]==1 && dis[nR][nC] > nT){
                    dis[nR][nC] = nT;
                    vector<int> t = {nR, nC, nT};
                    q.push(t);
                }
            }
       }
       return dis;

    }
};