class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        int start = 0;
        int end = n - 1;
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(citations[mid] >= (n - mid)){
                ans = n - mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return ans;
    }
};