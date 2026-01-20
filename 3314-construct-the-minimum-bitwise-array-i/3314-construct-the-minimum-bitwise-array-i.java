class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int res[] = new int[n];
        Arrays.fill(res, -1);
        for(int i = 0; i < n; i++){
            if((nums.get(i) & 1) == 1){
                for(int j = 0; j < nums.get(i); j++){
                    if((j | (j + 1)) == nums.get(i)){
                        res[i] = j;
                        break;
                    }
                }
            }
        }
        return res;
    }
}