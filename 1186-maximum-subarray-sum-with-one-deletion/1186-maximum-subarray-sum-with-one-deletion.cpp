class Solution {
public:
    int maximumSum(vector<int>& arr) {
        int n = arr.size();
        vector<int> left(n), right(n);
        int curr = arr[0];
        int global = arr[0];
        left[0] = arr[0];
        for(int i = 1; i < n; i++){
            curr = max(arr[i], curr + arr[i]);
            global = max(global, curr);
            left[i] = curr;
        }

        curr = arr[n - 1];
        global = arr[n - 1];
        right[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--){
            curr = max(arr[i], curr + arr[i]);
            global = max(global, curr);
            right[i] = curr;
        }
        int ans = global;
        for(int i = 1; i < n - 1; i++){
            ans = max(ans, left[i - 1] + right[i + 1]);
        }
        return ans;
    }
};