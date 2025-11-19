class Solution {
public:
    int dfs(int node, vector<vector<int>>& adj, set<int>& vis){
        vis.erase(node);
        int cnt = 1;
        for (auto it : adj[node]) {
            if (vis.find(it) != vis.end()) {
                cnt = dfs(it, adj, vis) + 1;
            }
        }
        return cnt;
    }

    int longestCycle(vector<int>& edges) {
        int n = edges.size();
        vector<vector<int>> adj(n);

        for (int i = 0; i < n; i++) {
            if (edges[i] == -1) continue;
            adj[i].push_back(edges[i]);
        }

        vector<int> inorder(n, 0);
        for (int i = 0; i < n; i++) {
            for (auto it : adj[i]) {
                inorder[it]++;
            }
        }

        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == 0) q.push(i);
        }

        while (!q.empty()) {
            int node = q.front(); 
            q.pop();

            if (adj[node].empty()) continue;

            int it = adj[node][0];
            inorder[it]--;
            if (inorder[it] == 0) {
                q.push(it);
            }
            adj[node].clear();  // instead of erase(it)
        }

        set<int> vis;
        for (int i = 0; i < n; i++) {
            if (inorder[i] != 0) vis.insert(i);
        }
        if (vis.empty()) return -1;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!adj[i].empty() && vis.find(i) != vis.end()) {
                ans = max(ans, dfs(i, adj, vis));
            }
        }
        return ans == 0 ? -1 : ans;
    }
};
