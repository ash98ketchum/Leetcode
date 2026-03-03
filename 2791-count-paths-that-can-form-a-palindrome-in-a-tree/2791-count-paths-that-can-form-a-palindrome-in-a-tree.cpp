class Solution {
public:
    void dfs(int node, int mask, vector<vector<int>>& adj,
             vector<int>& masks, string& s) {
        
        if(node != 0) {
            mask ^= (1 << (s[node] - 'a'));
        }
        
        masks[node] = mask;
        
        for(int child : adj[node]) {
            dfs(child, mask, adj, masks, s);
        }
    }
    
    long long countPalindromePaths(vector<int>& parent, string s) {
        int n = parent.size();
        
        vector<vector<int>> adj(n);
        for(int i = 1; i < n; i++) {
            adj[parent[i]].push_back(i);
        }
        
        vector<int> masks(n);
        
        // Step 1: compute mask for every node
        dfs(0, 0, adj, masks, s);
        
        // Step 2: count valid pairs
        unordered_map<int, long long> freq;
        long long ans = 0;
        
        for(int i = 0; i < n; i++) {
            
            int mask = masks[i];

            ans += freq[mask];

            for(int b = 0; b < 26; b++) {
                int newMask = mask ^ (1 << b);
                if(freq.count(newMask)) {
                    ans += freq[newMask];
                }
            }
            
            freq[mask]++;
        }
        
        return ans;
    }
};