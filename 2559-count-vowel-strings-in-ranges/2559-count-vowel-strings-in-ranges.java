class Solution {
    public int[] vowelStrings(String[] s, int[][] queries) {
        int n = s.length;
        int[] check = new int[n];
        for (int i = 0; i < n; i++) {
            char first = s[i].charAt(0);
            char last = s[i].charAt(s[i].length() - 1);
            if (isVowel(first) && isVowel(last)) {
                check[i] = 1;
            } else {
                check[i] = 0;
            }
        }
        int[] prefixsum = new int[n];
        prefixsum[0] = check[0];
        for (int i = 1; i < n; i++) {
            prefixsum[i] = prefixsum[i - 1] + check[i];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = l == 0 ? prefixsum[r] : prefixsum[r] - prefixsum[l - 1];
        }

        return res;
    }
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
