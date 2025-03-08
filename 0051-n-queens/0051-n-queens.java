class Solution {
    public static boolean checker(int r, int c, List<StringBuilder> board, int n) {
        // Vertical condition
        for (int i = r - 1; i >= 0; i--) {
            if (board.get(i).charAt(c) == 'Q') return false;
        }

        // Left diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        // Right diagonal
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        return true;
    }

    public static void myrec(List<List<String>> res, List<StringBuilder> board, int n, int r, int cnt) {
        if (cnt == n) {
            List<String> tempBoard = new ArrayList<>();
            for (StringBuilder sb : board) {
                tempBoard.add(sb.toString());
            }
            res.add(tempBoard);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!checker(r, i, board, n)) continue;

            board.get(r).setCharAt(i, 'Q');
            myrec(res, board, n, r + 1, cnt + 1);
            board.get(r).setCharAt(i, '.');
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<StringBuilder> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(new StringBuilder(".".repeat(n)));
        }

        myrec(res, board, n, 0, 0);
        return res;
    }
}
