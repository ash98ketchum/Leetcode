class Solution {
    private boolean mycutiepatootie(int mid,int nums[],int n){
        int cnt=0;
        //every decision of my girl is right
        //because i m one of those
        for(int i=0;i<n;i++){
            if(nums[i]<=mid){
                cnt++;
            }
        }
        return cnt>mid;
    }
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int start=1;
        int end=n;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mycutiepatootie(mid,nums,n)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}