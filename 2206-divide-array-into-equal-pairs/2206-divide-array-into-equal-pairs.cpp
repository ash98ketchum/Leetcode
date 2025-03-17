class Solution {
public:
    bool divideArray(vector<int>& arr) {
        int n = arr.size();
        map<int,int> mp;
        for(auto it : arr) mp[it]++;
        int cnt = 0;
        for(auto pair : mp){
            if(pair.second % 2 != 0){
                return false;
            }
            else{
                cnt += (pair.second/2);
            }
        }
        return cnt == n/2;
    }
};