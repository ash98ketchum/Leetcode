class Solution {
    public static int myrec(int idx,int curr, int nums[]){
        if(idx == nums.length){
            return curr;
        }
        int notake = myrec(idx + 1, curr, nums);
        int take = myrec(idx + 1, curr ^ nums[idx], nums);
        return take + notake;
    }
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        return myrec(0,0, nums);
    }
}