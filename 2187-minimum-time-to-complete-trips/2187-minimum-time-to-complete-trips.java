class Solution {
    public boolean myfunc(long mid, int time[], int totalTrips){
        long tot = 0;
        for(int i = 0; i< time.length; i++){
            tot += mid/time[i];
        }
        return tot >= totalTrips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long ans = -1;
        long low = 1, high = Integer.MAX_VALUE;

        for(int it: time){
            high = Math.min(it, high) * totalTrips;
        }
        while(low <= high){
            long mid = low + (high - low)/2;
            if(myfunc(mid, time, totalTrips)){
                high = mid - 1;
                ans = mid;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}