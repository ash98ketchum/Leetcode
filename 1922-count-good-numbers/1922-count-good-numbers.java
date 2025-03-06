class Solution {
    public static long binaryexpo(long a,long b,long MOD){
        if(b==0){
            return 1;
        }
        long ans=binaryexpo(a,b/2,MOD);
        //pow is even
        if(b % 2 == 0){
            return ((ans%MOD)*(ans%MOD))%MOD;
        }else{// pow is odd
            return ((((ans%MOD)*(ans%MOD))%MOD)*a%MOD)%MOD;
        }
    }
    public int countGoodNumbers(long n) {
        // number of even indexes lets say n=5
        // _ _ _ _ _ => 0,1,2,3,4=> 3 =>(n+1)/2;
        //number of odd indexes
        // n/2;
        long MOD=1000000000+7;
        long evenidx=(n+1)/2;
        //[0 2 4 6 8] for even
        //[2 3 5 7] for odd
        long oddidx=n/2;
        return (int)((binaryexpo(5,evenidx,MOD)%MOD)*(binaryexpo(4,oddidx,MOD)%MOD)%MOD);
    }
}