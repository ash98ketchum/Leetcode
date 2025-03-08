class Solution {
    public static void myrec(List<List<Integer>> res, List<Integer> temp, int nums[], int n, int idx){
        res.add(new ArrayList<>(temp));
        
        for(int i = idx; i < n; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            myrec(res,temp,nums,n,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        myrec(res,temp,nums,n,0);
        return res;
    }
}