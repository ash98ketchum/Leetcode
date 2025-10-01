class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        List<Integer> res = new ArrayList<>();
        if (m < n) return res;

        int[] freqP = new int[26];
        int[] freqS = new int[26];
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            freqS[s.charAt(i) - 'a']++;
            if (i >= n) {
                freqS[s.charAt(i - n) - 'a']--;
            }

            if (Arrays.equals(freqP, freqS)){
                res.add(i - n + 1);
            }
        }

        return res;
    }
}
