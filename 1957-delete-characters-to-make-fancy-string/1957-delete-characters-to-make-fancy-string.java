class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        
        for (int i = 0; i < n; ) {
            char x = s.charAt(i);
            res.append(x);
            int count = 1;
            while (i + 1 < n && s.charAt(i + 1) == x) {
                count++;
                i++;
            }
            if (count > 1) {
                res.append(x);
            }
            i++;
        }
        
        return res.toString();
    }
}
