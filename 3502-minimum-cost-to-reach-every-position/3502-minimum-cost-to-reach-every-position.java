class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int minn = cost[0];
        int res[] = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = Math.min(minn, cost[i]);
            minn = res[i];
        }
        return res;
    }
}