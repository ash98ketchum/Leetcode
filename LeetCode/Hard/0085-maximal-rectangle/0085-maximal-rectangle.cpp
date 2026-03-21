class Solution {
public:
    int myfunc(vector<int> &heights){
        stack<int> st;
        int n = heights.size();
        int area = 0;

        for(int i = 0; i <= n; i++){
            int h = (i == n ? 0 : heights[i]);

            while(!st.empty() && heights[st.top()] > h) {
                int height = heights[st.top()];
                st.pop();

                int right = i;
                int left = st.empty() ? -1 : st.top();

                area = max(area, height * (right - left - 1));
            }
            st.push(i);
        }
        return area;
    }

    int maximalRectangle(vector<vector<char>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();

        vector<int> h(m, 0);
        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1') h[j]++;
                else h[j] = 0;
            }
            ans = max(ans, myfunc(h));
        }

        return ans;
    }
};