class Solution {
    public int minCost(String s, int[] arr) {
        int n = s.length();
        int ans = 0;
        char ch = s.charAt(0);
        int max = arr[0];
        int sum = arr[0];
        for(int i = 1; i < n;i++){
            if(s.charAt(i) == ch){
                max = Math.max(max, arr[i]);
                sum += arr[i];
            }
            else{
                ans += (sum - max);
                max = arr[i];
                sum = arr[i];
                ch = s.charAt(i);
            }
        }
        ans += (sum - max);
        return ans;
    }
}