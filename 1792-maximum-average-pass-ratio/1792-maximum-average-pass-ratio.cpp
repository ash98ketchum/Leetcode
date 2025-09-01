class Solution {
public:
    double maxAverageRatio(vector<vector<int>>& classes, int extraStudents) {
        auto gain = [](int p, int t) {
            return (double)(t - p) / (t * (t + 1.0));
        };

        priority_queue<pair<double, pair<int,int>>> pq;
        for (auto &c : classes) {
            int p = c[0], t = c[1];
            pq.push({gain(p, t), {p, t}});
        }
        while (extraStudents--) {
            auto [delta, cls] = pq.top();
            pq.pop();
            int p = cls.first, t = cls.second;
            p++; t++;
            pq.push({gain(p, t), {p, t}});
        }
        double sum = 0.0;
        while (!pq.empty()) {
            auto [delta, cls] = pq.top();
            pq.pop();
            sum += (double)cls.first / cls.second;
        }
        return sum / classes.size();
    }
};
