class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n=words.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isprefixandsuffix(words[i],words[j])){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private boolean isprefixandsuffix(String a,String b){
        return (b.startsWith(a) && b.endsWith(a));
    }
}