class Solution {
public:
    struct Trie {
        vector<vector<int>> nodes;
        Trie() : nodes(1, vector<int>(26, -1)) {}

        void insertWord(const string& word) {
            int current = 0;
            for (char c : word) {
                int index = c - 'a';
                if (nodes[current][index] == -1) {
                    nodes[current][index] = nodes.size();
                    nodes.push_back(vector<int>(26, -1));
                }
                current = nodes[current][index];
            }
        }

        int findPrefixes(const string& target, int start, vector<int>& dp) {
            int current = 0;
            for (int i = start; i < target.size(); ++i) {
                int index = target[i] - 'a';
                if (nodes[current][index] == -1) {
                    return -1;
                }
                current = nodes[current][index];
                dp[i + 1] = min(dp[i + 1], dp[start] + 1);
            }
            return dp[target.size()];
        }
    };

    int minValidStrings(vector<string>& words, string target) {
        Trie trie;

        for (const string& word : words) {
            trie.insertWord(word);
        }

        int n = target.size();
        vector<int> dp(n + 1, numeric_limits<int>::max());
        dp[0] = 0;

        for (int i = 0; i < n; ++i) {
            if (dp[i] != numeric_limits<int>::max()) {
                trie.findPrefixes(target, i, dp);
            }
        }

        return dp[n] == numeric_limits<int>::max() ? -1 : dp[n];
    }
};