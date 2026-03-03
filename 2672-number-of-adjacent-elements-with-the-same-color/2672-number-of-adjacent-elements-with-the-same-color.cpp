class Solution {
public:
    vector<int> colorTheArray(int n, vector<vector<int>>& queries) {
        
        vector<int> colors(n, 0);
        vector<int> ans;
        int count = 0;
        
        for(auto &q : queries) {
            int index = q[0];
            int color = q[1];
            if(colors[index] != 0) {
                if(index > 0 && colors[index] == colors[index - 1]) {
                    count--;
                }
                if(index < n - 1 && colors[index] == colors[index + 1]) {
                    count--;
                }
            }
            colors[index] = color;
            if(index > 0 && colors[index] == colors[index - 1]) {
                count++;
            }
            if(index < n - 1 && colors[index] == colors[index + 1]) {
                count++;
            }
            ans.push_back(count);
        }
        return ans;
    }
};