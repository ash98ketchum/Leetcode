class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end());
        int cnt = 1;
        int n = points.size();
        int end = points[0][1];
        for(int i = 1; i < n; i++){
            if(points[i][0]>end){
                cnt++;
                end = points[i][1];
            }
            end = min(points[i][1], end);
        }
        return cnt;

    }
};