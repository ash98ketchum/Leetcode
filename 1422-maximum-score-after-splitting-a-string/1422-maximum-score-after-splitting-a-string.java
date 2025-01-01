class Solution {
    public int maxScore(String s) {
        int totones=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                totones++;
            }
        }
        int maxx=0;
        int leftxero=0;
        int rightones=totones;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0'){
                leftxero++;
            }
            else{
                rightones--;
            }
            maxx=Math.max(maxx,leftxero+rightones);
        }
        return maxx;
    }
}