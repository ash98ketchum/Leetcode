class Solution {
    public static boolean mycutiedivyanshi(int mid, int nums[], int n, int k){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] <= mid){
                cnt++;
                i++;
            }
        }
        return cnt >= k;
    }
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int start = 1;
        int end = 0;
        for(int i = 0; i < n; i++){
            end = Math.max(end, nums[i]);
        }
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mycutiedivyanshi(mid, nums, n, k)){
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