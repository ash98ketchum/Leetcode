class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        map<int,int> mp;
        int n=nums.size();
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int p=nums[i]*nums[j];
                mp[p]++;
            }
        }
        for(auto pair:mp){
            ans+= (pair.second * (pair.second - 1) / 2) * 8;
        }
        return ans;
    }
};