class Solution {
    final static int MOD = 1000000000 + 7;
    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> mp = new HashMap<>();
        for(int[] it : points){
            mp.put(it[1], mp.getOrDefault(it[1], 0L) + 1);
            //java sucks
        }

        long s = 0;
        long cnt = 0;
        for(long it : mp.values()){
            if(it >=2){
                long temp = (it* (it - 1)/2) % MOD;
                s = (s + (temp * cnt) %MOD)%MOD;
                cnt = (cnt + temp) %MOD;
            }
        }
        return (int)s;
    }
            
}