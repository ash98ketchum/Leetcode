class Solution {
public:
    pair<int, vector<int>> myfunc(int n){
        vector<int> facts;
        for(int i = 1; i*i <= n; i++){
            if(n % i == 0){
                facts.push_back(i);
                if(i != n/i){
                    facts.push_back(n/i);
                }
            }
        }
        return make_pair(facts.size(), facts);
    }
    int sumFourDivisors(vector<int> &nums) {
        int ans = 0;
        int n = nums.size();
        for(int i = 0; i < n; i++){
            pair<int, vector<int>> p = myfunc(nums[i]);
            if(p.first == 4){
                ans += accumulate(p.second.begin(), p.second.end(), 0);
            }
        }
        return ans;
    }
};