class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD=1000000007;
        long evencnt=1;
        long oddcnt=0;
        long p=0;
        for(int it:arr){
            p=(p+(it% 2 + 2) % 2) % 2;
            if(p==0) evencnt++;
            else oddcnt++;
        }
        long res=(evencnt*oddcnt)%MOD;
        return (int)res;
    }
}