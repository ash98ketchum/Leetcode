class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        set<int> st;
        for(int it : nums) st.insert(it);
        int ans = 0;
        for(int it : st){
            if(st.find(it - 1) == st.end()){
                int curr = it;
                int len = 1;
                while(st.find(curr + 1) != st.end()){
                    curr++;
                    len++;
                }
                ans = max(ans, len);
            }
            
        }
        return ans;
    }
};