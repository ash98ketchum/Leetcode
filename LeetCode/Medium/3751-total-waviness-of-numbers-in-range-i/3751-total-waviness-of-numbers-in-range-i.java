class Solution {
    public int totalWaviness(int num1, int num2) {
        int tot = 0;
        for(int i = num1; i <= num2; i++){
            String s = Integer.toString(i);
            if(s.length() < 3) continue;
            int cnt = 0;
            for(int j = 1; j < s.length() - 1; j++){
                if(s.charAt(j) > s.charAt(j - 1) && s.charAt(j) > s.charAt(j + 1)) cnt++;
                if(s.charAt(j) < s.charAt(j - 1) && s.charAt(j) < s.charAt(j + 1)) cnt++;
            }
            tot += cnt;
                
        }
        return tot;
    }
}