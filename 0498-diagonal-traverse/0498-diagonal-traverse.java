class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        ArrayList<ArrayList<Integer>> ranks = new ArrayList<>();
        for(int i = 0; i <= n+m ; i++){
            ranks.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ranks.get(i + j).add(mat[i][j]);
            }
        }
        for(int i = 0; i < ranks.size(); i++){
            if(i%2==0) Collections.reverse(ranks.get(i));
        }
        int ans[] = new int[n * m];
        int idx = 0;
        for(ArrayList<Integer> arr : ranks){
            for(int it : arr){
                ans[idx] = it;
                idx++;
            }
        }
        return ans;

    }
}