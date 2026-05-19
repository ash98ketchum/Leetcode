class Solution {
public:
    int getCommon(vector<int>& nums1, vector<int>& nums2) {
        int l1= nums1.size();
        int l2= nums2.size();
        

        //hehe now two pointer :)
        int i=0,j=0;
        int common=-1;
        while (i < l1 && j < l2){
            if(nums1[i]<nums2[j]){
                i+=1;
                continue;
            }
            else if(nums1[i]>nums2[j]){
                j+=1;
                continue;
            }
            else{
                common=nums1[i];
                break;
            }
        }
        return common;
    }
};