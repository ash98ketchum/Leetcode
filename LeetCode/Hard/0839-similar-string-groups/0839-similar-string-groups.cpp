class Solution {
public:
    vector<int> par, sz;

    int find(int node){
        if(par[node] == node) return node;
        return par[node] = find(par[node]);
    }

    void unite(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return;

        if(sz[pu] > sz[pv]){
            par[pv] = pu;
            sz[pu] += sz[pv];
        } else {
            par[pu] = pv;
            sz[pv] += sz[pu];
        }
    }

    int numSimilarGroups(vector<string>& strs) {
        int n = strs.size();

        par.resize(n);
        sz.resize(n, 1);
        iota(par.begin(), par.end(), 0);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isSimilar(strs[i], strs[j])){
                    unite(i, j);
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(find(i) == i) cnt++;
        }

        return cnt;
    }

    bool isSimilar(string &a, string &b){
        int diff = 0;
        for(int i = 0; i < a.size(); i++){
            if(a[i] != b[i]) diff++;
            if(diff > 2) return false;
        }
        return (diff == 0 || diff == 2);
    }
};