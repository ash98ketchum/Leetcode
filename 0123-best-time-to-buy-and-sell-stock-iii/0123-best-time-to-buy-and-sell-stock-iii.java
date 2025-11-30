class Solution {

    public int myrec(int idx, int[] prices, int cnt, boolean hold, Integer[][][] dp) {

        if (cnt == 2) return 0;
        if (idx == prices.length) return 0;

        
        if (dp[idx][cnt][hold ? 1 : 0] != null)
            return dp[idx][cnt][hold ? 1 : 0];

        int skip = myrec(idx + 1, prices, cnt, hold, dp);

        int ans;
        if(!hold){
            int buy = -prices[idx] + myrec(idx + 1, prices, cnt, true, dp);
            ans = Math.max(skip, buy);
        } 
        else{
            int sell = prices[idx] + myrec(idx + 1, prices, cnt + 1, false, dp);
            ans = Math.max(skip, sell);
        }

        return dp[idx][cnt][hold ? 1 : 0] = ans;
    }

    public int maxProfit(int[] prices) {
        Integer[][][] dp = new Integer[prices.length][3][2];
        return myrec(0, prices, 0, false, dp);
    }
}
