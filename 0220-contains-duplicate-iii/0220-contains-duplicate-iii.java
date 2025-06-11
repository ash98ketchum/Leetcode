class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            long n = nums[i];
            
            Long x = set.floor(n + valueDiff);
            Long y = set.ceiling(n - valueDiff);
            
            if((x != null && x >= n) || (y != null && y <= n)){
                return true;
            }
            set.add(n);
            
            if(i >= indexDiff){
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}