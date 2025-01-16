class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        
        if(n1==n2){
            if(n1==1){
                return nums1[0]^nums2[0];
            }
            return 0;
        }
        else{
            int xor1=0;
            int xor2=0;
            for(int it:nums1) xor1^=it;
            for(int it:nums2) xor2^=it;
            int ans=0;
            if(n1%2==1){
                ans^=xor2;
            }
            if(n2%2==1){
                ans^=xor1;
            }
            return ans;
        }
    }
}