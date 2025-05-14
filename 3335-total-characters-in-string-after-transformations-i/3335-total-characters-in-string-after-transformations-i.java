class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        while (t-- > 0) {
            int[] newfreq = new int[26];
            for (int i = 0; i < 26; i++) {
                if (freq[i] >= 1) {
                    if (i == 25) {
                        newfreq[0] = (newfreq[0] + freq[i]) % MOD;
                        newfreq[1] = (newfreq[1] + freq[i]) % MOD;
                    } else {
                        newfreq[i + 1] = (newfreq[i + 1] + freq[i]) % MOD;
                    }
                }
            }
            freq = newfreq;
        }

        int sum = 0;
        for (int val : freq) {
            sum = (sum + val) % MOD;
        }
        return sum;
    
    }
}