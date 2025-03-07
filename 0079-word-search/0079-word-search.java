class Solution {
    public static boolean myrec(char[][] board, String word, int n, int m, int len, boolean[][] visited, int idx, int r, int c){
        if (idx == len){
            return true;
        }
        if (r < 0 || c < 0 || r >= n || c >= m || board[r][c] != word.charAt(idx) || visited[r][c]){
            return false;
        }
        visited[r][c] = true;
        if (myrec(board, word, n, m, len, visited, idx + 1, r + 1, c) ||
        myrec(board, word, n, m, len, visited, idx + 1, r - 1, c) ||
        myrec(board, word, n, m, len, visited, idx + 1, r, c + 1) ||
        myrec(board, word, n, m, len, visited, idx + 1, r, c - 1)
        ){
            return true;
        }
        visited[r][c] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int len = word.length();
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (myrec(board, word, n, m, len, visited, 0, i, j)){
                    return true;
                }
            }
        }
        return false;

    }
}