class Solution {
    public int houserobber1(int[] nums) {
        //state -> total amount of money by robbing either (current and current -2) or (robbing current -1)

        //transition -> dp[x] = Math.max(nums[x] + dp[x-2], dp[x-1])
        //base condition -> dp[0] = 0; 
        // final subproblem -> dp[n-1]
        int n = nums.length;
        int b = nums[0];
        int a = 0; //dp[-1]
        int c =0;
        for(int i = 1; i < n; i++){
            if(i == 1){
                c = Math.max(nums[i] + 0, b);// here 0 is dp[-1] because it doesn't exist and we need to make our transition formula generalized for all n 
            }
            else{
                c = Math.max(nums[i] + a, b);
            }
            a = b;
            b = c;
        }
        return b;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int temp[] = new int[nums.length - 1];
        int temp2[] = new int[nums.length - 1];

        for(int i = 0; i <= n-2 ;i++){
            temp[i] = nums[i];
        }
        for(int i = 1; i <= n-1 ;i++){
            temp2[i-1] = nums[i];
        }
        int answith1st = houserobber1(temp);
        int answithlast = houserobber1(temp2);
        return Math.max(answith1st, answithlast);
    }
}