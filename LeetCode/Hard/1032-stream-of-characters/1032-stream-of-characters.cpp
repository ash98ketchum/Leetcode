struct TrieNode {
    TrieNode* children[26];
    bool isEnd;

    TrieNode() {
        isEnd = false;
        for (int i = 0; i < 26; i++) children[i] = NULL;
    }
};
class StreamChecker {
private:
    TrieNode* root;
    string stream;

public:
    StreamChecker(vector<string>& words) {
        root = new TrieNode();

        // insert reversed words
        for (string word : words) {
            reverse(word.begin(), word.end());
            TrieNode* node = root;

            for (char c : word) {
                int idx = c - 'a';
                if (!node->children[idx]) {
                    node->children[idx] = new TrieNode();
                }
                node = node->children[idx];
            }
            node->isEnd = true;
        }
    }

    bool query(char letter) {
        stream.push_back(letter);

        TrieNode* node = root;

        // check from end of stream
        for (int i = stream.size() - 1; i >= 0; i--) {
            int idx = stream[i] - 'a';

            if (!node->children[idx]) return false;

            node = node->children[idx];

            if (node->isEnd) return true;
        }

        return false;
    }
};
/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker* obj = new StreamChecker(words);
 * bool param_1 = obj->query(letter);
 */