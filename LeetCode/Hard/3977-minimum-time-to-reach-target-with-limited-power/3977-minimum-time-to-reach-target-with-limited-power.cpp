using ll = long long;
class Solution {
public:
    vector<long long> minTimeMaxPower(int n, vector<vector<int>>& edges, int power, vector<int>& cost, int source, int target) {
        vector<vector<pair<ll, ll>>> adj(n);
        for(auto it : edges){
            adj[it[0]].push_back({it[1], it[2]});
        }
        priority_queue<array<ll, 3>, vector<array<ll, 3>>, greater<array<ll, 3>>> pq;
        vector<ll> mp(n, -1);
        
        pq.push({0, -power, source});
        
        while(!pq.empty()){
            auto [t, np, u] = pq.top();
            pq.pop();
            
            ll p = -np;
            
            if (u == target) return {t, p};
            if (p <= mp[u]) continue;
            mp[u] = p;
            
            if (p >= cost[u]) {
                for (auto& edge : adj[u]) {
                    ll v = edge.first;
                    ll dt = edge.second;
                    if (p - cost[u] > mp[v]) {
                        pq.push({t + dt, -(p - cost[u]), v});
                    }
                }
            }
        }
        return {-1LL, -1LL};
    }
};