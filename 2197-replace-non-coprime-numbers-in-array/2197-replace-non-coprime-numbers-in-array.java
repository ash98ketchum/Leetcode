class Solution {
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public int lcm(int a, int b){
        return (int)(((long)a * b) / gcd(a, b));
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> st = new ArrayList<>();
        for(int num : nums){
            while(!st.isEmpty() && gcd(st.get(st.size()-1), num) > 1){
                num = lcm(st.remove(st.size()-1), num);
            }
            st.add(num);
        }
        return st;
    }
}
