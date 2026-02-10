class Solution {
public:
    
    int getDepth(int x) {
        return 32 - __builtin_clz(x) - 1;
    }

    int getLCA(int a, int b) {
        while (a != b) {
            if (a > b) a /= 2;
            else b /= 2;
        }
        return a;
    }

    vector<int> cycleLengthQueries(int n, vector<vector<int>>& queries) {
        vector<int> ans;
        for (auto &q : queries) {
            int a = q[0];
            int b = q[1];
            int da = getDepth(a);
            int db = getDepth(b);
            int lca = getLCA(a, b);
            int dl = getDepth(lca);
            int dist = da + db - 2 * dl;

            ans.push_back(dist + 1);
        }

        return ans;
    }
};
