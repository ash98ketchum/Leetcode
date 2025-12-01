class Solution {
public:
    bool myfunc(long long k, vector<int> &arr, int n){
        long long tot = 0;
        for(auto it : arr){
            tot += min((long long)it, k);
        }
        return tot >= n * k;
    }
    long long maxRunTime(int n, vector<int>& batteries) {
        sort(batteries.begin(), batteries.end());
        long long start = 0;
        long long end = 1e14;
        long long ans = 0;
        while(start <= end){
            long long mid = start + (end - start)/2;
            if(myfunc(mid, batteries, n)){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return ans;
    }
};