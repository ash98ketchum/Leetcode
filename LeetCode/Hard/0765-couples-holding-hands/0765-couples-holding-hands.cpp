class Solution {
public:
    vector<int> par;
    int find(int node){
        if(node == par[node]) return par[node] = node;
        return par[node] = find(par[node]);
    }
    void unite(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu != pv){
            par[pv] = pu;
        }
    }
    int minSwapsCouples(vector<int>& row) {
        int n = row.size()/2;
        par.resize(n + 1);
        iota(par.begin(), par.end(), 0);

        for(int i = 0; i < 2 * n; i+=2){
            unite(row[i]/2, row[i + 1]/2);
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(find(par[i]) == i) cnt++;
        }
        return n - cnt;
    }
};