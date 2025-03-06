class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        boolean visited[]=new boolean[n*n+1];
        int res[]=new int[2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[grid[i][j]]){
                    res[0]=grid[i][j];
                }
                else{
                    visited[grid[i][j]]=true;
                }
            }
        }
        for(int i=1;i<=n*n;i++){
            if(!visited[i]) res[1]=i;
        }
        return res;

    }
}