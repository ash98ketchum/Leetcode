class Solution {
private: 
    long long calc(int L, int R, int k) {
        /*
            There are L elements (smaller or greater) to the left including index i
                      R elements (smaller or grater) to the right including index i
            Thus, total number of elements = L + R - 1 since i is counted twice
            
            Now, we need number of subarrays of length <= k
            = Total number of subarrays - #subarrays with length > k

            Extra elements E = L + R - 1 - k
            Number of subarrays with E excess elements = 1
            Number of subarrays with (E - 1) excess elements = 2
            Number of subarrays with (E - 2) excess elements = 3
            ...
            Number of subarrays with 1 excess elements = E

            Let's take an example: 
            L = 4, R = 6, K = 6
            length = L + R - 1 = 9
            E = L + R - 1 - K = 3
            In an array of size = length = 9: 
                Required elements K = 6
                Extra elements E = 3

                Number of subarrays with E excess elements 
                = Number of subarrays with (K + E) = 9 elements = 1

                Number of subarrays with (E - 1) excess elements
                = Number of subarrays with (K + E - 1) = 8 elements = 2

                Number of subarrays with (E - 2) excess elements
                = Number of subarrays with (K + E - 2) = 7 elements = 3

                Since E = 3, no need to consider E - 3, ...

            Total number of extra subarrays T = 1 + 2 + 3 = 6
            Thus, number of subarrays with length <= K: L * R - T = 18
        */

        /*
            Also, we don't need to worry about the cases where index i itself is not included in the subarray because extra (E) is always < min(L, R)

            We are considering at most k elements to the left (and right)
            Thus, L <= k and R <= k
            L + R - 1 <= 2 * k - 1
            extra E = L + R - 1 - k
            E <= 2 * k - 1 - k
            E <= k - 1
            E < k and k >= min(L, R)
            E < min(L, R)

            Therefore, in our formulation, 
                there are no subarrays where we will omit the index i
        */

        int extra = max(0, L + R - 1 - k); 
        long long sub = (1LL * extra * (extra + 1)) / 2; 
        return 1LL * L * R - sub; 
    }

public:
    long long minMaxSubarraySum(vector<int>& nums, int k) {
        int n = nums.size(); 
        vector<int> lMin(n, -1), rMin(n, n); 
        vector<int> lMax(n, -1), rMax(n, n); 
        stack<int> stMin, stMax; 
        for (int i = 0 ; i < n ; i++) {
            while (!stMin.empty() && nums[stMin.top()] > nums[i]) stMin.pop(); 
            if (!stMin.empty()) lMin[i] = stMin.top(); 
            stMin.push(i); 

            while (!stMax.empty() && nums[stMax.top()] < nums[i]) stMax.pop(); 
            if (!stMax.empty()) lMax[i] = stMax.top(); 
            stMax.push(i); 
        }

        while (!stMin.empty()) stMin.pop(); 
        while (!stMax.empty()) stMax.pop();

        for (int i = n - 1 ; i >= 0 ; i--) {
            while (!stMin.empty() && nums[stMin.top()] >= nums[i]) stMin.pop(); 
            if (!stMin.empty()) rMin[i] = stMin.top(); 
            stMin.push(i); 

            while (!stMax.empty() && nums[stMax.top()] <= nums[i]) stMax.pop(); 
            if (!stMax.empty()) rMax[i] = stMax.top(); 
            stMax.push(i); 
        }

        long long res = 0; 
        for (int i = 0 ; i < n ; i++) {
            int leftMin = min(i - lMin[i], k); 
            int rightMin = min(rMin[i] - i, k); 
            res += nums[i] * calc(leftMin, rightMin, k); 

            int leftMax = min(i - lMax[i], k); 
            int rightMax = min(rMax[i] - i, k); 
            res += nums[i] * calc(leftMax, rightMax, k); 
        }
        return res; 
    }
};