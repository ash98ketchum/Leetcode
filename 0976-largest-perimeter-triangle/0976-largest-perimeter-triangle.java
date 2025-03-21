class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int perimeter = 0;
        int n=nums.length;
        for(int i=n-1;i>=2;i--){
            int a=nums[i];
            int b=nums[i-1];
            int c=nums[i-2];
            if(a<b+c){
                perimeter=a+b+c;
                break;
            }
        }
        return perimeter;
    }
}