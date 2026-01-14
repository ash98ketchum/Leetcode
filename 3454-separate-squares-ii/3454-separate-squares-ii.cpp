class Solution {
public:
    double separateSquares(vector<vector<int>>& squares) {
        vector<tuple<long long, int, long long, long long>> events;

        for (auto &sq : squares) {
            long long x = sq[0], y = sq[1], l = sq[2];
            events.push_back({y, 1, x, x + l});
            events.push_back({y + l, -1, x, x + l});
        }

        sort(events.begin(), events.end());

        vector<pair<long long, long long>> xs;
        long long prev_y = get<0>(events[0]);
        double total = 0;
        vector<tuple<long long, long long, long long>> areas;

        auto union_len = [&](vector<pair<long long, long long>>& intervals) {
            sort(intervals.begin(), intervals.end());
            long long res = 0;
            long long end = LLONG_MIN;

            for (auto &it : intervals) {
                long long a = it.first, b = it.second;
                if (a > end) {
                    res += b - a;
                    end = b;
                } else if (b > end) {
                    res += b - end;
                    end = b;
                }
            }
            return res;
        };

        for (auto &[y, typ, x1, x2] : events) {
            if (y > prev_y && !xs.empty()) {
                long long h = y - prev_y;
                long long w = union_len(xs);
                areas.push_back({prev_y, h, w});
                total += (double)h * w;
            }

            if (typ == 1) {
                xs.push_back({x1, x2});
            } else {
                // remove interval
                for (auto it = xs.begin(); it != xs.end(); ++it) {
                    if (it->first == x1 && it->second == x2) {
                        xs.erase(it);
                        break;
                    }
                }
            }
            prev_y = y;
        }

        double half = total / 2.0;
        double acc = 0;

        for (auto &[y, h, w] : areas) {
            double area = (double)h * w;
            if (acc + area >= half) {
                return y + (half - acc) / w;
            }
            acc += area;
        }

        return 0.0;
    }
};
