struct PairHash {
    size_t operator()(const pair<double,double>& p) const {
        size_t h1 = hash<double>()(p.first);
        size_t h2 = hash<double>()(p.second);
        return h1 ^ (h2 + 0x9e3779b97f4a7c15ULL + (h1<<6) + (h1>>2));
    }
};
struct PairEq {
    bool operator()(const pair<double,double>& a, const pair<double,double>& b) const {
        return a.first == b.first && a.second == b.second;
    }
};
struct TupleHash {
    size_t operator()(const tuple<double,double,int>& t) const {
        size_t h1 = hash<double>()(get<0>(t));
        size_t h2 = hash<double>()(get<1>(t));
        size_t h3 = hash<int>()(get<2>(t));
        size_t r = h1 ^ (h2 + 0x9e3779b97f4a7c15ULL + (h1<<6) + (h1>>2));
        return r ^ (h3 + 0x9e3779b97f4a7c15ULL + (r<<6) + (r>>2));
    }
};
struct TupleEq {
    bool operator()(const tuple<double,double,int>& a, const tuple<double,double,int>& b) const {
        return get<0>(a)==get<0>(b) && get<1>(a)==get<1>(b) && get<2>(a)==get<2>(b);
    }
};

class Solution {
public:
    int countTrapezoids(vector<vector<int>>& points) {
        vector<pair<int,int>> seen_points;
        unordered_map<double,int> parallel_count;
        unordered_map<pair<double,double>,int,PairHash,PairEq> same_line_count;
        unordered_map<pair<double,double>,int,PairHash,PairEq> parallel_side_count;
        unordered_map<tuple<double,double,int>,int,TupleHash,TupleEq> same_line_side_count;

        long long result = 0;
        long long rhombus_twice = 0;

        for (auto& p1 : points) {
            int x1 = p1[0], y1 = p1[1];
            for (auto& p2 : seen_points) {
                int x2 = p2.first, y2 = p2.second;
                int dx = x1 - x2;
                int dy = y1 - y2;

                double k, b;
                if (dx == 0) {
                    k = INFINITY;
                    b = x1;
                } else {
                    k = (double)dy / (double)dx;
                    b = (double)y1 - k * (double)x1;
                    k = round(k * 1e8) / 1e8;
                    b = round(b * 1e8) / 1e8;
                }

                double slope_id = k;
                pair<double,double> line_id = {k,b};

                result += (long long)parallel_count[slope_id] - (long long)same_line_count[line_id];
                parallel_count[slope_id]++;
                same_line_count[line_id]++;

                int side_len = dx*dx + dy*dy;
                pair<double,double> slope_side = {k,(double)side_len};
                tuple<double,double,int> line_side = {k,b,side_len};

                rhombus_twice += (long long)parallel_side_count[slope_side] - (long long)same_line_side_count[line_side];
                parallel_side_count[slope_side]++;
                same_line_side_count[line_side]++;
            }
            seen_points.push_back({x1,y1});
        }
        return (int)(result - rhombus_twice/2);
    }
};