class Solution {
    public double pow(double x,int n){
        if(n==0){
            return 1;
        }
        double ans=pow(x,n/2);
        //pow is even
        if(n % 2 == 0){
            return ans*ans;
        }else{// pow is odd
            return ans*ans*x;
        }
    }
    public double myPow(double x, int n) {
        double res=pow(x,Math.abs(n));
        if(n<0){
            return 1.0/res;
        }
        return res;
        

        
    }
}