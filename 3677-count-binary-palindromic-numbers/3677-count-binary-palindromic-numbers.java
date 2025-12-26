class Solution {
    public String toBinary(long n){
        if(n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            if(n % 2 == 1){
                sb.append('1');
            }else{
                sb.append('0');
            }
            n /=2;
        }
        return sb.reverse().toString();
    }
    public int countBinaryPalindromes(long n) {
        if(n == 0) return 1;
        String bin = toBinary(n);
        int cnt = 1;
        int len = bin.length();
        for(int i = 1; i < len; i++){
            if(i == 1){
                cnt++;
            }
            else{
                cnt += (1L << ((i - 1)/2));
            }
        }
        int half = (len + 1)/2;
        String s2 = bin.substring(0, half);

        long a = Long.parseLong(s2, 2);
        long b = (1L << (half - 1));
        cnt += a - b;
        String rev = new StringBuilder(s2).reverse().toString();
        String val;
        if(len %2 == 1){
            val = s2 + rev.substring(1);
        }
        else{
            val = s2 + rev;
        }
        if(Long.parseLong(val, 2) <= n) cnt++;
        return cnt;
    }
}