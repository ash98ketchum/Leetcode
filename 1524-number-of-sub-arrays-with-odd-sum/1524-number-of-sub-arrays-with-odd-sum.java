class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD=1000000007;
        long evencnt=1;
        long oddcnt=0;
        long p=0;
        int[] pref=new int[arr.length];
        pref[0]=arr[0];
        for(int i=1;i<arr.length;i++) pref[i]=pref[i-1]+arr[i];
        for(int it:pref){
            if(it%2==0) evencnt++;
            else oddcnt++;
        }
        long res=(evencnt*oddcnt)%MOD;
        return (int)res;
    }
}