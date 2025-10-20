class Solution {
public:
    int finalValueAfterOperations(vector<string>& operations) {
        int cnt = 0;
        for(auto it : operations) if(it == "X++" || it == "++X") cnt++;
        return cnt - (operations.size() - cnt);
    }
};