class Solution {
public:
    int scheduleCourse(vector<vector<int>>& courses) {
        sort(courses.begin(), courses.end(), [](const vector<int>&a, const vector<int>&b){
            return a[1] < b[1];
        });

        priority_queue<int> pq;
        int dur = 0;
        for(auto it : courses){
            int len = it[0];
            int last = it[1];
            dur += len;
            pq.push(len);

            while(dur > last){
                dur -= pq.top();
                pq.pop();
            }
        }
        return pq.size();
    }
};