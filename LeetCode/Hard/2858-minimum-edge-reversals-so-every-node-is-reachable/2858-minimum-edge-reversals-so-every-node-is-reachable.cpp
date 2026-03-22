class Solution {
public:
    vector<vector<pair<int, int>>> adj;
    vector<int> ans;
    int dfs(int node, int par){
        int cost = 0;
        for(auto it : adj[node]){
            if(it.first != par){
                cost += it.second + dfs(it.first, node);
            }
        }
        return cost;
    }
    void dfs2(int node, int par){
        for(auto it : adj[node]){
            if(it.first != par){
                if(it.second == 0) ans[it.first] = ans[node] + 1;
                else ans[it.first] = ans[node] - 1;
                dfs2(it.first, node);
            }
        }
    }
    vector<int> minEdgeReversals(int n, vector<vector<int>>& edges) {
        adj.resize(n);
        ans.resize(n);
        for(auto it : edges){
            int u = it[0];
            int v = it[1];
            adj[u].push_back({v,0});
            adj[v].push_back({u, 1});
        }

        ans[0] = dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }
};