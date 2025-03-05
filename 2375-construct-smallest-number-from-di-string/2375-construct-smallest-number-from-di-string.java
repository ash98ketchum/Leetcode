class Solution {
    
    public String smallestNumber(String pattern) {
        int ans[]=new int[pattern.length()+1];
        int cnt=1;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=pattern.length();i++){
            if(i==pattern.length() || pattern.charAt(i)=='I'){
                ans[i]=cnt;
                cnt++;
                while(!st.isEmpty()){
                    ans[st.pop()]=cnt;
                    cnt++;
                }
            }
            else{
                st.push(i);
            }
        }
        String res="";
        for(int it:ans){
            res+=it;
        }
        return res;
    }
}