class Solution {
public:
    int collectTheCoins(vector<int>& coins, vector<vector<int>>& edges) {
        int n = coins.size();
        vector<vector<int>> adj(n);
        vector<int> degree(n, 0);
        for(auto it : edges){
            adj[it[0]].push_back(it[1]);
            adj[it[1]].push_back(it[0]);
            degree[it[0]]++;
            degree[it[1]]++;
        }

        queue<int> q;
        for(int i = 0; i < n; i++){
            if(degree[i] == 1 && coins[i] == 0) q.push(i);
        }
        vector<int> del(n, 0);
        while(!q.empty()){
            int node = q.front();
            q.pop();
            del[node] = 1;
            for(auto it : adj[node]){
                degree[it]--;
                if(degree[it] == 1 && coins[it] == 0 && !del[it]) q.push(it);
            }
            
        }

        for(int k = 0; k < 2; k++){
            vector<int> l;
            for(int i = 0; i < n; i++){
                if(degree[i] == 1 && !del[i]) l.push_back(i);
            }
            for(auto x : l){
                del[x] = 1;
                for(auto it : adj[x]){
                    degree[it]--;
                }
            }
        }
        int rem = 0;
        for(int i = 0; i < n; i++){
            if(!del[i]) rem++;
        }
        return max(0, 2 * (rem - 1));


    }
};