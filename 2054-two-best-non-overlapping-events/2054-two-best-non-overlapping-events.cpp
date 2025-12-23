class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events){
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>>pq;
        sort(events.begin(), events.end());
        int maxx = 0, tot = 0;

        for(auto it : events){
            while(pq.size() && pq.top().first < it[0]) {
                maxx = max(maxx, pq.top().second);
                pq.pop();
            }

            tot = max(tot, maxx + it[2]);
            pq.push({it[1], it[2]});
        }

        return tot;
    }
};