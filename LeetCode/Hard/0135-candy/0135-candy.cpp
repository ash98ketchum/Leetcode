class Solution {
public:
    int candy(vector<int>& rating) {
        int n = rating.size();
        vector<int> candies(n, 1);
        for(int i = 1; i < n; i++){
            if(rating[i] > rating[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i--){
            if(rating[i] > rating[i + 1]){
                candies[i] = max(candies[i], candies[i + 1] + 1);
            }
        }
        int sum = accumulate(candies.begin(), candies.end(), 0);
        return sum;
    }
};