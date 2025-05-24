class Solution {
    public static int divyanshicutie(int nums[], int k){
           HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int cnt = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        while(end < n){
            // grow
            // char ch = s.charAt(end);
            map.put(nums[end], map.getOrDefault(nums[end],0) + 1);
            
            // shrink
            while(start <= end && map.size() > k){
                if(map.get(nums[start]) == 1){
                    map.remove(nums[start]);
                } else {
                    map.put(nums[start], map.get(nums[start])- 1);
                }
                start++;
            }
            
            // ans update
            cnt += end  - start + 1;
            end++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
      return divyanshicutie(nums, k) - divyanshicutie(nums, k- 1);
    }
}