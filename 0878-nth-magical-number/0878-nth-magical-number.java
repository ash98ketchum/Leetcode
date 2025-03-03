class Solution {
    private int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    private long mydivyanshi(long mid,int n, long lcm,int a,int b){
        return mid/a + mid/b - mid/lcm;
    }
    public int nthMagicalNumber(int n, int a, int b) {
        int MOD=1000000000+7;
        long start=Math.min(a,b);
        long end=start*(long)n;
        long ans=0;
        long lcm=((long)a*b)/gcd(a,b);
        while(start<=end){
            long mid=start+(end-start)/2;
            if(mydivyanshi(mid,n,lcm,a,b)>=n){
                end=mid-1;
                ans=mid;
            }
            else{
                start=mid+1;
            }
        }
        return (int)(ans%MOD);
    }
}