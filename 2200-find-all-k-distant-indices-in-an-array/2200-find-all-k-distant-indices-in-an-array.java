class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;

        int res[] = new int[nums.length];
        for(int i = 0; i < n; i++){
            if(nums[i] == key){
                for(int j = Math.max(0,i - k); j < Math.min(i+k+1, n); j++){
                    res[j] = 1;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(res[i] == 1){
                ans.add(i);
            }
        }
        return ans;
    }
}