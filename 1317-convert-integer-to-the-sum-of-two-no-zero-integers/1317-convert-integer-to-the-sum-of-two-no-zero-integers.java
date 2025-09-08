class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i <= n; i++){
            int a = i;
            int b = n - i;
            String as = Integer.toString(a);
            boolean flag = true;
            for(int j = 0; j < as.length(); j++){
                if(as.charAt(j) == '0'){
                    flag = false;
                    break;
                }
            }
            String bs = Integer.toString(b);
            for(int j = 0; j < bs.length(); j++){
                if(bs.charAt(j) == '0'){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return new int[]{a, b};
            }
        }
        return new int[]{-1,-1};
    }
}