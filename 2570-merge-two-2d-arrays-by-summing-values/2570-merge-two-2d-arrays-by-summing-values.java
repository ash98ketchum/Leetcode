class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Arrays.sort(nums1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(nums2, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]>res= new ArrayList<>();
        int i=0;
        int j=0;
        int n=nums1.length;
        int m=nums2.length;
        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) {
                res.add(new int[] {nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                res.add(new int[] {nums1[i][0], nums1[i][1]});
                i++;
            } else {
                res.add(new int[] {nums2[j][0], nums2[j][1]});
                j++;
            }
        }
        while (i < n) {
            res.add(new int[] {nums1[i][0], nums1[i][1]});
            i++;
        }
        while (j < m) {
            res.add(new int[] {nums2[j][0], nums2[j][1]});
            j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}