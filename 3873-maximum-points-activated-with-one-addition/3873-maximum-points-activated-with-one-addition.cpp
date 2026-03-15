class Solution {
public:
    vector<int> par, sz;
    int find(int node){
        if(par[node] == node){
            return node;
        }
        return par[node] = find(par[node]);
    }
    void unionbysize(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return;
        if(sz[pu] > sz[pv]){
            par[pv] = pu;
            sz[pu] += sz[pv];
        }
        else{
            par[pu] = pv;
            sz[pv] += sz[pu];
        }

    }
    int maxActivated(vector<vector<int>>& points) {
        int n = points.size();
        par.resize(n + 1);
        iota(par.begin(), par.end(), 0);
        sz.resize(n + 1, 1);
        map<int, int> mpx, mpy;
        for(int i = 0; i < n; i++){
            int x = points[i][0];
            int y = points[i][1];
            if(mpx.find(x) != mpx.end()){
                unionbysize(i, mpx[x]);
            }
            else{
                mpx[x] = i;
            }
            if(mpy.find(y) != mpy.end()){
                unionbysize(i, mpy[y]);
            }
            else{
                mpy[y] = i;
            }
        }
        set<int> roots;
        for(int i = 0; i < n; i++) roots.insert(find(i));
        vector<int> comp;
        comp.reserve(roots.size());
        for(int r : roots) {
            comp.push_back(sz[r]);
        }
        sort(comp.begin(), comp.end());
        reverse(comp.begin(), comp.end());
        if(comp.size() >= 2) return comp[0] + comp[1] + 1;
        else return comp[0] + 1;
    }
};