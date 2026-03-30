class SummaryRanges {
public:
    vector<int> par;
    vector<int> sz;
    set<int> st;
    int find(int node){
        if(node == par[node]) return par[node] = node;
        return par[node] = find(par[node]);
    }
    void unite(int u, int v){
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
    SummaryRanges() {
        par.resize(3e4 + 5);
        sz.resize(3e4 + 5, 1);
        iota(par.begin(), par.end(), 0);
    }
    
    void addNum(int value) {
        if(st.find(value + 1) != st.end()) unite(value, value + 1);
        if(st.find(value - 1) != st.end()) unite(value - 1, value);
        st.insert(value);
    }
    
    vector<vector<int>> getIntervals() {
        vector<vector<int>> res;
        if(st.empty()) return res;

        auto it = st.begin();
        int start = *it;
        int prev = *it;

        it++;
        while(it != st.end()){
            if(*it == prev + 1){
                prev = *it;
            }
            else{
                res.push_back({start, prev});
                start = *it;
                prev = *it;
            }
            it++;
        }
        res.push_back({start, prev});

        return res;
    }
};

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges* obj = new SummaryRanges();
 * obj->addNum(value);
 * vector<vector<int>> param_2 = obj->getIntervals();
 */