class Solution {
    private static boolean myfunc(int mid,int nums[],int k,int n){
        int cnt=1;
        int sum=0;
        for(int i=0;i<n;i++){
            if(sum+nums[i]<=mid){
                sum+=nums[i];
            }
            else{
                cnt++;
                sum=nums[i];
            }
        }
        return cnt<=k;

    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int start=-1;
        int end=0;
        for(int it:nums){
            start=Math.max(start,it);
            end+=it;
        }
        int divyanshicutu=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(myfunc(mid,nums,k,n)){
                divyanshicutu=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return divyanshicutu;
    }
}