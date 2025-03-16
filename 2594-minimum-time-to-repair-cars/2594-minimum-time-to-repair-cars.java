class Solution {
    public static boolean divyanshiislub(long mid, int ranks[], int n, int cars){
        long cnt = 0;
        for(int i = 0; i < n; i++){
            cnt += (long) Math.sqrt(mid / ranks[i]);
        }
        return cnt >= cars;
    }
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        int n = ranks.length;
        long start = 1;
        long end = 1000000000000000l;
        long ans = -1;
        while(start <= end){
            long mid = start + (end - start)/2;
            if(divyanshiislub(mid, ranks, n, cars)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;


    }
}