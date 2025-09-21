#include <bits/stdc++.h>
using namespace std;

struct Pair {
    string s;
    int dist;
    Pair(string s, int dist) : s(s), dist(dist) {}
};
struct Compare {
    bool operator()(const Pair &a, const Pair &b) {
        return a.dist > b.dist;
    }
};

class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        string src = "0000";
        set<string> deadset(deadends.begin(), deadends.end());
        if (deadset.count(src)) return -1;

        set<string> visited;
        priority_queue<Pair, vector<Pair>, Compare> pq;
        pq.push(Pair(src, 0));
        visited.insert(src);

        while (!pq.empty()) {
            Pair it = pq.top();
            pq.pop();

            string currState = it.s;
            int dist = it.dist;

            if (currState == target) return dist;

            for (int i = 0; i < 4; i++) {
                string nextState = currState;

                // +1 move
                nextState[i] = (char) ((currState[i] - '0' + 1) % 10 + '0');
                if (!deadset.count(nextState) && !visited.count(nextState)) {
                    pq.push(Pair(nextState, dist + 1));
                    visited.insert(nextState);
                }

                // -1 move
                nextState = currState;
                nextState[i] = (char) ((currState[i] - '0' - 1 + 10) % 10 + '0');
                if (!deadset.count(nextState) && !visited.count(nextState)) {
                    pq.push(Pair(nextState, dist + 1));
                    visited.insert(nextState);
                }
            }
        }
        return -1;
    }
};
