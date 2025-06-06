class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int s1 = 0, s2 = 0, fSum = 0, sSum = 0, m1 = 0, m2 = 0;
        for(int i = 0; i < n; i++){
          s1 += nums1[i];
          s2 += nums2[i];
        }
        
        int ans = Math.max(s1, s2);
        for(int i = 0; i < n; i++){
            fSum += nums2[i] - nums1[i];
            sSum += nums1[i] - nums2[i];
            
            m1 = Math.max(m1, fSum);
            m2 = Math.max(m2, sSum);
            
            if(fSum < 0) fSum = 0;
            if(sSum < 0) sSum = 0;
        }
        ans = Math.max(s1 + m1, ans);
        ans = Math.max(s2 + m2, ans);
        return ans;
    }
}