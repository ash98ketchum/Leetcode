class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        int k2 = k/2;
        long orig[] = new long[n];
        long pref[] = new long[n + 1];
        long pref2[] = new long[n + 1];
        for(int i = 0; i <  n; i++){
            orig[i] = (long)(strategy[i] * prices[i]);
            pref[i + 1] = pref[i] + orig[i];
            pref2[i + 1] = pref2[i] + (long)prices[i];
        }

        long ans = pref[n];
        long best = 0;
        for(int i = 0; i + k <=n ; i++){
            long sum1 = pref[i + k] - pref[i];
            long sum2 = pref2[i + k] - pref2[i + k2];
            long diff = sum2 - sum1;
            if(diff > best){
                best = diff;
            }
            
        }
        return ans + best;

        
    }
}