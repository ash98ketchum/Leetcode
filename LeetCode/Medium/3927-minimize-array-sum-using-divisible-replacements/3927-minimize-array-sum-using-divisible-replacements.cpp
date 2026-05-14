class Solution {
public:
    long long minArraySum(vector<int>& nums) {
        vector<int> line(1e5 + 69, 0);
        sort(nums.begin(), nums.end());
        for(auto it : nums){
            if(it <= 1) return (nums.size() * it);
            line[it] = it;
        }
        
        for(int it : nums){
            for(int i = it; i < 1e5 + 69; i += it){
                if(it < line[i])
                    line[i] = it;
            }
        }
        for(int i = 0; i < 20; i++){
            cout << line[i] << " ";
        }
        cout << endl;
        
        long long sum = 0;
        for(auto it : nums){
            sum += line[it];
        }
        return sum;
    }
};