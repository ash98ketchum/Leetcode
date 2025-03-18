import java.util.*;

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start = 0, end = 0, tot = 0;
        List<Integer> subarray = new ArrayList<>();
        
        while (end < nums.length){
            boolean flag = false;
            for (int num : subarray){
                if ((num & nums[end]) != 0){
                    flag = true;
                    break;
                }
            }
            
            if (!flag) {
                subarray.add(nums[end]);
                tot = Math.max(tot, end - start + 1);
                end++;
            } else {
                subarray.remove(0);
                start++;
            }
        }
        
        return tot;
    }
}
