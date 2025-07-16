class Solution {
    // public static boolean myrec(int curr, int last, int k, Set<Integer> set, int first, Map<String, Boolean> dp){
    //     if(k <= 0 && curr != first) return false;
    //     if(!set.contains(curr)) return false;
    //     if(curr == last) return true;
        
        
    //     String s = curr + "," + k;
    //     if(dp.containsKey(s)) return dp.get(s);
        
        
    //     boolean call1 = false, call2 = false, call3 = false;
    //     if(curr == first){
    //         call2 = myrec(curr + k, last, k, set, first, dp);
    //     }
    //     else{
    //         call1 = myrec(curr + k - 1, last, k - 1, set, first, dp);
    //         call2 = myrec(curr + k, last, k, set, first, dp);
    //         call3 = myrec(curr + k + 1, last, k + 1, set, first, dp);
    //     }
        
        
    //     dp.put(s, call1 || call2 || call3); 
    //     return call1 || call2 || call3;
    // }
    public boolean canCross(int[] stones) {
        int n = stones.length;
        // Set<Integer> set = new HashSet<>();
        // for(int it : stones){
        //     set.add(it);
        // }
        // Map<String, Boolean> dp = new HashMap<>();
        // int curr = stones[0];
        // int last = stones[n - 1];
        boolean dp[][] = new boolean[n][n+1];
        
        dp[0][1] = true;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                int diff = stones[i] - stones[j];
                if(diff < 0 || diff > n || !dp[j][diff]) continue;
                dp[i][diff] = true;
                if(diff - 1 >= 0) dp[i][diff - 1] = true;
                if(diff + 1 <= n) dp[i][diff + 1] = true;
                if(i == n-1) return true;
            }
        }
        return false;
    }
}