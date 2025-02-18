class Solution {
    private String result = "";

    private boolean backtrack(String pattern, StringBuilder num, boolean[] used, int index) {
        if (index == pattern.length() + 1) {
            result = num.toString();
            return true;
        }

        for (char digit = '1'; digit <= '9'; digit++) {
            if (used[digit - '1']) continue;

            if (index == 0 || 
                (pattern.charAt(index - 1) == 'I' && num.charAt(index - 1) < digit) ||
                (pattern.charAt(index - 1) == 'D' && num.charAt(index - 1) > digit)) {

                num.append(digit);
                used[digit - '1'] = true;

                if (backtrack(pattern, num, used, index + 1)) return true;

                num.deleteCharAt(num.length() - 1);
                used[digit - '1'] = false;
            }
        }
        return false;
    }
    public String smallestNumber(String pattern) {
        boolean[] used = new boolean[9];
        StringBuilder num = new StringBuilder();
        backtrack(pattern, num, used, 0);
        return result;
    }
}