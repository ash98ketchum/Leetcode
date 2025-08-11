class Solution {
    final static long MOD = 1_000_000_007;

    private long modPow(long a, long e) {
        long res = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }

    private long modInv(long x) {
        return modPow(x, MOD - 2);
    }
    public int[] productQueries(int n, int[][] queries) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        while(n > 0){
            int x = 1;
            for(int i = 0; i < 31; i++){
                x = (1 << i);
                if(x > n){
                    x/=2;
                    break;
                }
            }
            n -= x;
            arr.add(x);
        }
        Collections.sort(arr);
        int m = arr.size();
        long[] pref = new long[m + 1];
        pref[0] = 1;
        for (int i = 1; i <= m; i++) {
            pref[i] = (pref[i - 1] * (arr.get(i - 1) % MOD)) % MOD;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            long res = (pref[r + 1] * modInv(pref[l])) % MOD;
            ans[i] = (int) res;
        }
        return ans;
    }
}