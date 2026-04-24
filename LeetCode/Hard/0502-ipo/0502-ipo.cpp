class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        int n = profits.size();
        vector<pair<int, int>> projects;

        // {(c, p), (c, p)....}
        for(int i = 0; i < n; i++){
            projects.push_back({capital[i], profits[i]});
        }
        sort(projects.begin(), projects.end()); // sorted according to capital

        priority_queue<int> pq;
        int idx = 0;
        while(k--){
            while(idx < n && projects[idx].first <= w) pq.push(projects[idx++].second);
            // check all the projects which u can do now and push the profits into max heap
            if(pq.empty()) break;
            // try to do project which gives max profit

            w += pq.top();
            pq.pop();
        }
        return w;


    }
};