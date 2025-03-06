class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int ans=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int val=heights[st.pop()];
                int r=i;
                if(st.isEmpty()){
                    ans=Math.max(val*r,ans);
                }
                else{
                    int l=st.peek();
                    int area=val*(r-l-1);
                    ans=Math.max(area,ans);
                }
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int h=heights[st.pop()];
            if(st.isEmpty()){
                ans=Math.max(h*n,ans);
            }
            else{
                int l=st.peek();
                int area=h*(n-l-1);
                ans=Math.max(area,ans);
            }
        }
        return ans;
    }
}