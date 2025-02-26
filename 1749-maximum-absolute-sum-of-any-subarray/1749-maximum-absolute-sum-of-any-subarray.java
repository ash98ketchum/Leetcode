class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxcurr=0;
        int mincurr=0;
        int maxtot=0;
        int mintot=0;
        for(int it:nums){
            maxcurr=Math.max(0,maxcurr+it);
            maxtot=Math.max(maxtot,maxcurr);
            mincurr=Math.min(0,mincurr+it);
            mintot=Math.min(mintot,mincurr);
        }
        return Math.max(maxtot,-mintot);
    }
}