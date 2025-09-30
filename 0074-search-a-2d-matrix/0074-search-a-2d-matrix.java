class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //m,n=100 => m*n =10000 or 1e4 maximum TC=1e8=> m^2*n^2
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(matrix[i][j]==target){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        int n=matrix.length;
        int m=matrix[0].length;
        int row=-1;
        int start=0;
        int end=n-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] <= target && (mid == n - 1 || matrix[mid + 1][0] > target)) {
                row = mid;
                break;
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(row==-1) return false;
        //i found the col
        start=0;
        end=m-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
        
    }
}