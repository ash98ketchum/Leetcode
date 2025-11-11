class Data {
    int idx;
    int cnt0;
    int cnt1;
    Data(int idx, int cnt0, int cnt1) {
        this.idx = idx;
        this.cnt0 = cnt0;
        this.cnt1 = cnt1;
    }
}

class Solution {
    int[][][] dp;

    public int myrec(String[] strs, Data[] data, int idx, int len, int c0, int c1) {
        if (c0 < 0 || c1 < 0) return Integer.MIN_VALUE;
        if (idx == len) return 0;
        if (dp[idx][c0][c1] != -1) return dp[idx][c0][c1];

        int take = Integer.MIN_VALUE;
        if (c0 >= data[idx].cnt0 && c1 >= data[idx].cnt1)
            take = 1 + myrec(strs, data, idx + 1, len, c0 - data[idx].cnt0, c1 - data[idx].cnt1);

        int notake = myrec(strs, data, idx + 1, len, c0, c1);
        return dp[idx][c0][c1] = Math.max(take, notake);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        Data[] data = new Data[len];
        for (int i = 0; i < len; i++) {
            int cnt0 = 0, cnt1 = 0;
            for (char ch : strs[i].toCharArray()) {
                if (ch == '0') cnt0++;
                else cnt1++;
            }
            data[i] = new Data(i, cnt0, cnt1);
        }

        dp = new int[len][m + 1][n + 1];
        for (int i = 0; i < len; i++)
            for (int j = 0; j <= m; j++)
                for (int k = 0; k <= n; k++)
                    dp[i][j][k] = -1;

        return myrec(strs, data, 0, len, m, n);
    }
}
