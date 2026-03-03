class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end(), [](vector<int> &a, vector<int>& b){
            return a[0] < b[0];
        });

        vector<vector<int>> ans;

        int i = 0;
        while(i < intervals.size()){
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;

            while(j < intervals.size() && end >= intervals[j][0]){
                end = max(end, intervals[j][1]);
                j++;
            }

            ans.push_back({start, end});
            i = j;
        }

        return ans;
    }
};