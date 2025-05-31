class Solution {
    public int maximumPopulation(int[][] logs) {
        int coord[] = new int[2051];
        int max = Integer.MIN_VALUE;
        for(int it[]: logs){
            // r + 1 -> (it[1] - 1) + 1
            // l -> it[0]
            coord[it[0]]++;
            coord[(it[1] - 1) + 1]--;
        }
        int pref[] = new int[2051];
        pref[0] = coord[0];
        for(int i = 1; i < coord.length; i++){
            pref[i] = coord[i] + pref[i-1];
        }
        int ans = 0;
        for(int i = 0; i < pref.length; i++){
            if(pref[i] > max){
                max = pref[i];
                ans = i;
            }
        }
        return ans;
    }
}