class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        int ans = 0;
        int s = 0; int e = 0;
        while( e < n){
            if(nums[e] == 0) cnt ++;

            while(s <= e && cnt > k){
                if(nums[s] == 0) cnt--;
                s++;
            }
            ans = Math.max(ans, e - s + 1);
            e++;
        }
        return ans;
    }
}