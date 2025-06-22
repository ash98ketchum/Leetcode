class Solution {
    public String[] divideString(String s, int k, char fill) {
        boolean flag = s.length() % k == 0 ? true : false;
        if(!flag){
            int need = k - (s.length() % k);
            while(need-- > 0){
                s += fill;
            }
        }
        String[] res= new String[s.length()/k];
        for(int i = 0, j = 0; i < s.length(); i+=k, j++){
            res[j] = s.substring(i, i + k);
        }
        return res;
    }
}