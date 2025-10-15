class Solution {
public:
    bool myfunc(int k, vector<int> &nums, int n){
        int inc = 1;
        for(int i = 1; i < n; i++){
            if(i < n && i + k < n && (nums[i] > nums[i -1]) && (nums[i + k] > nums[i + k - 1])){
                inc++;
            }
            else{
                inc = 1;
            }
            if(inc >= k){
                return true;
            }
        }
        return false;
    }
    int maxIncreasingSubarrays(vector<int>& nums) {
        int n = nums.size();
        if(n == 2) return 1;
        int start = 0;
        int end = n/2;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(myfunc(mid, nums, n)){
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