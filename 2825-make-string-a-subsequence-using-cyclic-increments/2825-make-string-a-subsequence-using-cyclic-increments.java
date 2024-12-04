class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        int n = str1.length(), m = str2.length();
        while (i < n && j < m) {
            char current = str1.charAt(i);
            char target = str2.charAt(j);
            if (current == target || getNextChar(current) == target) {
                j++;
            }
            i++;
        }
        return j == m;
    }
    private static char getNextChar(char c) {
        return c == 'z' ? 'a' : (char) (c + 1);
    }
}