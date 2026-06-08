class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        ArrayList<Integer> res=new ArrayList<>();
        //first elements less than pivot
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                res.add(nums[i]);
            }
        }
        //now elements equal to pivot
        for(int i=0;i<n;i++){
            if(nums[i]==pivot){
                res.add(nums[i]);
            }
        }
        //now elements greater than pivot
        for(int i=0;i<n;i++){
            if(nums[i]>pivot){
                res.add(nums[i]);
            }
        }
        int ans[] = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

}