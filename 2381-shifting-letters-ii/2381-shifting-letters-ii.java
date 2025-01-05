class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int diff[]=new int[n];
        for(int shift[]:shifts){
            int start=shift[0];
            int end=shift[1];
            int dir=shift[2];
            if(dir==0){
                diff[start]-=1;
                if(end<n-1){
                    diff[end+1]+=1;
                }

            }
            else{
                diff[start]+=1;
                if(end<n-1){
                    diff[end+1]-=1;
                }
            }
        }
        int pref[]=new int[n];
        pref[0]=diff[0];
        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]+diff[i];
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int ch = (s.charAt(i) - 'a' + pref[i]) % 26;
            if (ch < 0) ch += 26;
            res.append((char) ('a' + ch));
        }

        return res.toString();
    }

}
