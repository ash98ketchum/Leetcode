class TreeAncestor {
    //kisi bhi node ke max parent (logn) hote hai thats why
    //dp[n][logn] -> precompute ki node ka kth ancestor kon h 
    //jese dp[3][1] -> 3 ka first ancestor
    int dp[][];
    int logn;
    int n;

    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        logn = 20;
        dp = new int[n][logn];
        for(int it[] : dp) Arrays.fill(it, -1);

        for (int i = 0; i < n; i++) {
            dp[i][0] = parent[i]; //sbka pehla pehla papa daal diya
        }
        for (int j = 1; j < logn; j++) {
            for (int i = 0; i < n; i++) {
                int mid = dp[i][j - 1];
                dp[i][j] = (mid == -1) ? -1 : dp[mid][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for(int i = 0; i < 20; i++){
            if((k & (1 << i)) != 0){
                node = dp[node][i];
                if(node == -1) return -1;
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
