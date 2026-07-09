class Solution {
public:
    vector<bool> pathExistenceQueries(int n, vector<int>& nums, int maxDiff, vector<vector<int>>& queries) {
        vector<int> ids(n);
        int cid = 1;
        ids[0] = cid;
        for(int i = 1; i < n; i++){
            if((nums[i] - nums[i - 1]) <= maxDiff) ids[i] = cid;
            else{
                cid++;
                ids[i] = cid;
            }
        }
        int q = queries.size();
        vector<bool> ans(q);
        for(int i = 0; i < q; i++){
            int u = queries[i][0];
            int v = queries[i][1];
            if(ids[u] == ids[v]) ans[i] = true;
            else ans[i] = false;
        }
        return ans;
    }
};