import java.util.Stack;

class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int letterCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == letter) {
                letterCount++;
            }
        }

        int inStack = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            while (!st.isEmpty() && st.peek() > ch && (st.size() - 1 + (n - i) >= k)) {
                if (st.peek() == letter) {
                    if (inStack - 1 + letterCount >= repetition) {
                        st.pop();
                        inStack--;
                    } else {
                        break;
                    }
                } else {
                    st.pop();
                }
            }
            if (st.size() < k) {
                if (ch == letter) {
                    st.push(ch);
                    inStack++;
                } else {
                    if (k - st.size() > repetition - inStack) {
                        st.push(ch);
                    }
                }
            }
            if (ch == letter) {
                letterCount--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }
        return sb.toString();
    }
}