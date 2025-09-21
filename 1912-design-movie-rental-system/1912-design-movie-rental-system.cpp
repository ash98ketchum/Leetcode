class MovieRentingSystem {
    struct MovieEntity {
        int shop, movie, price;
        bool operator<(const MovieEntity& other) const {
            if (price != other.price) return price < other.price;
            if (shop != other.shop) return shop < other.shop;
            return movie < other.movie;
        }
    };

    unordered_map<int, set<MovieEntity>> available;
    set<MovieEntity> rented;
    map<pair<int, int>, int> prices;

public:
    MovieRentingSystem(int n, vector<vector<int>>& entries) {
        for (auto& e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            MovieEntity me{shop, movie, price};
            prices[{shop, movie}] = price;
            available[movie].insert(me);
        }
    }

    vector<int> search(int movie) {
        vector<int> res;
        if (available.count(movie)) {
            int count = 0;
            for (const auto& me : available[movie]) {
                res.push_back(me.shop);
                if (++count == 5) break;
            }
        }
        return res;
    }

    void rent(int shop, int movie) {
        int price = prices[{shop, movie}];
        MovieEntity me{shop, movie, price};
        available[movie].erase(me);
        rented.insert(me);
    }

    void drop(int shop, int movie) {
        int price = prices[{shop, movie}];
        MovieEntity me{shop, movie, price};
        rented.erase(me);
        available[movie].insert(me);
    }

    vector<vector<int>> report() {
        vector<vector<int>> res;
        int count = 0;
        for (const auto& me : rented) {
            res.push_back({me.shop, me.movie});
            if (++count == 5) break;
        }
        return res;
    }
};