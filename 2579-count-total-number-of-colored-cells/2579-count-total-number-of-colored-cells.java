class Solution {
    public long coloredCells(int n) {
        long res=1;
        if(n==1) return res;
        long adder=4;
        for(int i=1;i<n;i++){
            res+=adder;
            adder+=4;
        }
        return res;

    }
}