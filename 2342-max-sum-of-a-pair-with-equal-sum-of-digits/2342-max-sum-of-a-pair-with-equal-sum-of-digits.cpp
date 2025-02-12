class Solution {
public:
    int digitsum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    int maximumSum(vector<int>& nums) {
        int n=nums.size();
        sort(nums.begin(),nums.end());
        map<int,vector<int>> mp;
        for(int i=0;i<n;i++){
            mp[digitsum(nums[i])].push_back(nums[i]);
        }
        int globmaxx=-1;
        for(auto pair:mp){
            if(pair.second.size()>=2){
                globmaxx=max(pair.second[pair.second.size()-1]+pair.second[pair.second.size()-2],globmaxx);
            }
        }
        return globmaxx;
    }
};