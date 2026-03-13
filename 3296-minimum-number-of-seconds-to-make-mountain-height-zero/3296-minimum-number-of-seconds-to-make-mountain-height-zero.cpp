class Solution {
public:
    long long minNumberOfSeconds(int mountainHeight, vector<int>& workerTimes) {

        using T = tuple<long long,long long,long long>;

        priority_queue<T, vector<T>, greater<T>> pq;

        for(long long w : workerTimes){
            pq.push({w, 1, w});
        }

        long long ans = 0;

        for(int i = 0; i < mountainHeight; i++){
            auto [time, k, w] = pq.top();
            pq.pop();

            ans = max(ans, time);

            k++;
            pq.push({time + k*w, k, w});
        }

        return ans;
    }
};