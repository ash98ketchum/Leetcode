import java.util.*;

class Solution {

    class State {
        String board, hand;
        int step;

        State(String b, String h, int s) {
            board = b;
            hand = h;
            step = s;
        }
    }

    public int findMinStep(String board, String hand) {
        char[] h = hand.toCharArray();
        Arrays.sort(h);
        hand = new String(h);

        Queue<State> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.offer(new State(board, hand, 0));
        vis.add(board + "#" + hand);

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.board.length() == 0)
                return cur.step;
            if (!canClear(cur.board, cur.hand))
                continue;

            for (int i = 0; i <= cur.board.length(); i++) {
                for (int j = 0; j < cur.hand.length(); j++) {
                    if (j > 0 && cur.hand.charAt(j) == cur.hand.charAt(j - 1))
                        continue;

                    char c = cur.hand.charAt(j);
                    if (i > 0 && cur.board.charAt(i - 1) == c) {
                        boolean isBlockEnd = (i == cur.board.length() || cur.board.charAt(i) != c);
                        
                        if (isBlockEnd) {
                            String nb = cur.board.substring(0, i) + c + cur.board.substring(i);
                            nb = remove(nb);

                            String nh = cur.hand.substring(0, j) + cur.hand.substring(j + 1);
                            String key = nb + "#" + nh;

                            if (!vis.contains(key)) {
                                vis.add(key);
                                q.offer(new State(nb, nh, cur.step + 1));
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
    private boolean canClear(String board, String hand) {
        int[] boardCnt = new int[26];
        int[] totalCnt = new int[26];

        for (char c : board.toCharArray()) {
            boardCnt[c - 'A']++;
            totalCnt[c - 'A']++;
        }
        
        for (char c : hand.toCharArray()) {
            totalCnt[c - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (boardCnt[i] > 0 && totalCnt[i] < 3)
                return false;
        }

        return true;
    }

    private String remove(String s) {
        boolean changed = true;
        while (changed) {
            changed = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length();) {
                int j = i;
                while (j < s.length() && s.charAt(j) == s.charAt(i))
                    j++;

                if (j - i >= 3) {
                    changed = true;
                } else {
                    sb.append(s.substring(i, j));
                }
                i = j;
            }
            s = sb.toString();
        }
        return s;
    }
}