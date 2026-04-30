class Node {
public:
    int key, value, freq;

    Node(int k, int v) {
        key = k;
        value = v;
        freq = 1;
    }
};
class LFUCache {
private:
    int capacity;
    int minFreq;

    unordered_map<int, Node*> keyMap;              // key → node
    unordered_map<int, list<Node*>> freqMap;       // freq → list of nodes

    // Update node frequency
    void updateFreq(Node* node) {
        int freq = node->freq;

        // remove from current freq list
        freqMap[freq].remove(node);

        // if this was the only node with minFreq → increase minFreq
        if (freq == minFreq && freqMap[freq].empty()) {
            minFreq++;
        }

        // move to next freq
        node->freq++;
        freqMap[node->freq].push_front(node);
    }

public:
    LFUCache(int capacity) {
        this->capacity = capacity;
        minFreq = 0;
    }

    int get(int key) {
        if (keyMap.find(key) == keyMap.end()) return -1;

        Node* node = keyMap[key];
        updateFreq(node);

        return node->value;
    }

    void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.find(key) != keyMap.end()) {
            Node* node = keyMap[key];
            node->value = value;
            updateFreq(node);
        } else {
            if (keyMap.size() == capacity) {
                // evict LFU + LRU
                Node* node = freqMap[minFreq].back();
                freqMap[minFreq].pop_back();
                keyMap.erase(node->key);
                delete node;
            }

            Node* newNode = new Node(key, value);
            keyMap[key] = newNode;
            freqMap[1].push_front(newNode);
            minFreq = 1;
        }
    }
};

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache* obj = new LFUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */