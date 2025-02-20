class Solution {
    public long binary2decimal(String st){
        int n = st.length();
        long x = 0;
        for(int i = 0; i < n; i++){
            if(st.charAt(n - 1 - i) == '1'){
                x += Math.pow(2, i);
            }
        }
        return x;
    }

    public String decimal2binary(int num, int length){
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }
        while (sb.length() < length) {
            sb.append('0');
        }
        return sb.reverse().toString();
    }

    public String findDifferentBinaryString(String[] nums) {
        Set<Long> st = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            st.add(binary2decimal(nums[i]));
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!st.contains((long) i)) {
                return decimal2binary(i, nums.length);
            }
        }
        return "";
    }
}
