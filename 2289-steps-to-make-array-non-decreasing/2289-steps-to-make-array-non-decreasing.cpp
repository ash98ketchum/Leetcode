class Solution {
public:
    int totalSteps(vector<int>& nums) {
        int n = nums.size();
        stack<int> st;

        vector<int> steps(n, 0);
        int ans = 0;

        for(int i = n - 1; i >= 0; i--){
            int cur = 0;

            while(!st.empty() && nums[i] > nums[st.top()]){
                cur = max(cur + 1, steps[st.top()]);
                st.pop();
            }

            steps[i] = cur;
            ans = max(ans, cur);
            st.push(i);
        }

        return ans;
    }
};
