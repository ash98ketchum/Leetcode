class Solution {
public:
    // void bfs(vector<vector<int>>&adj, int node,vector<bool>&vis){
    //     int n=graph.size();
    //     queue<int>q;
    //     q.push
    // }
    int orangesRotting(vector<vector<int>>& grid) {
       int n=grid.size();
       int m=grid[0].size();
       queue<vector<int>>q;
       //q -> {i, j, time}
       int c=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==2){
                vector<int> t = {i, j, 0};
                q.push(t);
            }
            else if(grid[i][j]==1){
                c++;
            }
        }
       }
       if(c==0){
        return 0;
       }
       // 0 -> r
       // 1 - > c
       // 2 -> time
       vector<vector<int>>dx={{-1,0},{1,0},{0,-1},{0,1}};
       int tot=0;
       int ans = 0;
       while(!q.empty() && c>0){
           vector<int> p = q.front();
            q.pop();
            ans = max(ans, p[2]);
            for(auto it:dx){
                int nR=p[0] + it[0];
                int nC=p[1] + it[1];
                int nT = p[2] + 1;
                if(nR>=0 && nR<n && nC>=0 && nC<m && grid[nR][nC]==1){
                    grid[nR][nC]=2;
                    c--;
                    vector<int> t = {nR, nC, nT};
                    q.push(t);
                }
            }
       }
       if(c == 0) return ans + 1;
       return -1;
    }
};
