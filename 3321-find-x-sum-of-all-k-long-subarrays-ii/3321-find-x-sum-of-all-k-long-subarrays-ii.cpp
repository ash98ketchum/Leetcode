class Solution {
public:
    vector<long long> findXSum(vector<int>& nums, int k, int x) {
        int n = nums.size();
        if (n < k) {
            return {};
        }

        vector<long long> answer;
        answer.reserve(n - k + 1);

        set<pair<int, int>> top_x;
        set<pair<int, int>> others;
        
        unordered_map<int, int> freq_map;
        
        long long current_x_sum = 0;

        auto balance = [&]() {
            while (top_x.size() < x && !others.empty()) {
                auto best_other = *others.rbegin();
                others.erase(prev(others.end())); 
                
                top_x.insert(best_other);
                current_x_sum += (long long)best_other.second * best_other.first;
            }
            
            while (top_x.size() > x) {
                auto worst_top = *top_x.begin();
                top_x.erase(top_x.begin());
                
                others.insert(worst_top);
                current_x_sum -= (long long)worst_top.second * worst_top.first;
            }
            
            while (!top_x.empty() && !others.empty() && *top_x.begin() < *others.rbegin()) {
                auto worst_top = *top_x.begin();
                auto best_other = *others.rbegin();

                top_x.erase(top_x.begin());
                others.erase(prev(others.end()));
                top_x.insert(best_other);
                others.insert(worst_top);
                
                current_x_sum -= (long long)worst_top.second * worst_top.first;
                current_x_sum += (long long)best_other.second * best_other.first;
            }
        };

        auto add = [&](int val) {
            int old_count = freq_map[val];
            int new_count = old_count + 1;
            freq_map[val] = new_count;

            if (old_count > 0) {
                if (top_x.erase({old_count, val})) {
                    current_x_sum -= (long long)val * old_count;
                } else {
                    others.erase({old_count, val});
                }
            }

            others.insert({new_count, val});
            balance();
        };

        auto remove = [&](int val) {
            int old_count = freq_map[val];
            int new_count = old_count - 1;
            freq_map[val] = new_count;

            if (top_x.erase({old_count, val})) {
                current_x_sum -= (long long)val * old_count;
            } else {
                others.erase({old_count, val});
            }

            if (new_count > 0) {
                others.insert({new_count, val});
            }
            balance();
        };

        for (int i = 0; i < k; ++i) {
            add(nums[i]);
        }
        answer.push_back(current_x_sum);

        for (int i = k; i < n; ++i) {
            remove(nums[i - k]);
            add(nums[i]);
            answer.push_back(current_x_sum);
        }

        return answer;
    }
};