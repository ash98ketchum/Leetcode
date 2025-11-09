class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() 
            && ((Character.isLowerCase(st.peek()) && Character.isUpperCase(ch)) || (Character.isLowerCase(ch) && Character.isUpperCase(st.peek())))
            && Character.toLowerCase(ch) ==  Character.toLowerCase(st.peek())){
                st.pop();
                // i++;
                continue;
            }
            st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}