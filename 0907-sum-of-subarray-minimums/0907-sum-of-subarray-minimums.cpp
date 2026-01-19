class Solution {
public:
    const int MOD = 1e9 + 7;

    vector<int> prevSmaller(vector<int>& arr) {
        int n = arr.size();
        vector<int> pse(n, -1);
        stack<int> st;

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] > arr[i]) {
                st.pop();
            }
            if (!st.empty()) pse[i] = st.top();
            st.push(i);
        }
        return pse;
    }

    vector<int> nextSmaller(vector<int>& arr) {
        int n = arr.size();
        vector<int> nse(n, n);
        stack<int> st;

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[i] < arr[st.top()]) {
                nse[st.top()] = i;
                st.pop();
            }
            st.push(i);
        }
        return nse;
    }

    int sumSubarrayMins(vector<int>& arr) {
        int n = arr.size();
        vector<int> pse = prevSmaller(arr);
        vector<int> nse = nextSmaller(arr);

        long long sum = 0;

        for (int i = 0; i < n; i++) {
            long long left = i - pse[i];
            long long right = nse[i] - i;
            sum = (sum + arr[i] * left % MOD * right % MOD) % MOD;
        }
        return sum;
    }
};
