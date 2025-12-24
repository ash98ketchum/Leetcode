class Solution {
public:
    int minimumBoxes(vector<int>& apple, vector<int>& capacity) {
        int sum = accumulate(apple.begin(), apple.end(), 0);
        sort(capacity.rbegin(), capacity.rend());

        for(int i = 0; i < capacity.size(); i++){
            if(capacity[i] >= sum){
                return i + 1;
            }
            sum -= capacity[i];
        }
        return capacity.size();
    }
};