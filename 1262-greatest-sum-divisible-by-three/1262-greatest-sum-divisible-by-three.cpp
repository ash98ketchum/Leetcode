class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        vector<int> ones, twos;
        int sum = 0;

        for (auto it : nums) {
            sum += it;
            if (it % 3 == 1) ones.push_back(it);
            else if (it % 3 == 2) twos.push_back(it);
        }

        if (sum % 3 == 0) return sum;

        sort(ones.begin(), ones.end());
        sort(twos.begin(), twos.end());

        int rem = sum % 3;
        int remove = 1e9;

        if (rem == 1) {
            if (!ones.empty()) remove = min(remove, ones[0]);
            if (twos.size() >= 2) remove = min(remove, twos[0] + twos[1]);
        } else {
            if (!twos.empty()) remove = min(remove, twos[0]);
            if (ones.size() >= 2) remove = min(remove, ones[0] + ones[1]);
        }

        if (remove == 1e9) return 0;
        return sum - remove;
    }
};
