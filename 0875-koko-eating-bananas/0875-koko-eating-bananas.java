class Solution {
    private static boolean myfunc(int mid,int piles[],int n,int hrs){
        long cnt=0;
        for(int i=0;i<n;i++){
            if(piles[i]<=mid){
                cnt++;
            }
            else{
                cnt+=piles[i]/mid;
                if(piles[i]%mid!=0) cnt++;
            }
        }
        return cnt<=hrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int start=1;
        int end=1000000007;
        int divyanshicutie=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(myfunc(mid,piles,n,h)){
                divyanshicutie=mid;
                // if he can eat in 10 hrs then he can also eat in >=10 hrs
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return divyanshicutie;// no return policy

    }
}