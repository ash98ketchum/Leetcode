class Solution {
public:
    int findRotateSteps(string ring, string key) {
        int n = ring.size();
        int m = key.size();
        vector<vector<int>> pos(26);
        for(int i = 0; i < n; i++) {
            pos[ring[i] - 'a'].push_back(i);
        }
        vector<vector<int>> d(n, vector<int>(m + 1, 1e9));
        queue<pair<int, int>> q;
        q.push({0, 0});
        d[0][0] = 0;
        
        int ans = 1e9;
        
        while(!q.empty()){
            auto [r, k] = q.front();
            q.pop();
            if(k == m){
                ans = min(ans, d[r][k]);
                continue;
            }
            for(int it : pos[key[k] - 'a']){
                int dist = abs(r - it);
                int tot = min(dist, n - dist) + 1;
                if(d[r][k] + tot < d[it][k + 1]){
                    d[it][k + 1] = d[r][k] + tot;
                    q.push({it, k + 1});
                }
            }
        }
        
        return ans;
    }
};