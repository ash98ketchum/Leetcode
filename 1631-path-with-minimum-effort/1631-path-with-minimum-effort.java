class Solution {
    public boolean check(int mid, int mat[][]){
        boolean vis[][] = new boolean[mat.length][mat[0].length];
        return dfs(mid, mat, 0,0, vis);
        
    }
    public boolean dfs(int mid, int mat[][], int i, int j, boolean vis[][]){
        int n = mat.length;
        int m = mat[0].length;
        if(i == mat.length - 1 && j == mat[0].length -1){
            return true;
        }
        vis[i][j] = true;
        
        // i -1 j
        if(i - 1 >= 0 && Math.abs(mat[i - 1][j] - mat[i][j]) <= mid && !vis[i - 1][j]){
            if(dfs(mid, mat, i - 1, j, vis)){
                return true;
            }
        }
        if(i + 1 < n && Math.abs(mat[i + 1][j] - mat[i][j]) <= mid && !vis[i + 1][j]){
            if(dfs(mid, mat, i + 1, j, vis)){
                return true;
            }
        }
        if(j - 1 >= 0 && Math.abs(mat[i][j - 1] - mat[i][j]) <= mid && !vis[i][j - 1]){
            if(dfs(mid, mat, i, j - 1,  vis)){
                return true;
            }
        }
        if(j + 1 < m && Math.abs(mat[i][j + 1] - mat[i][j]) <= mid && !vis[i][j + 1]){
            if(dfs(mid, mat, i, j + 1, vis)){
                return true;
            }
        }
        return false;
    }
    public int minimumEffortPath(int[][] heights) {
        int l = 0, h = Integer.MAX_VALUE;
        int ans = -1;
        while(l <= h){
            int mid = l + (h- l)/2;
            if(check(mid, heights)){
                ans = mid;
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}