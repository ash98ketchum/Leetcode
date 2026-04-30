class Node {
public:
    int key, value;
    Node* prev;
    Node* next;

    Node(int k, int v) {
        key = k;
        value = v;
        prev = next = NULL;
    }
};
class LRUCache {
private:
    int capacity;
    unordered_map<int, Node*> mp;

    Node* head;
    Node* tail;

    // Remove node from list
    void remove(Node* node) {
        Node* prevNode = node->prev;
        Node* nextNode = node->next;

        prevNode->next = nextNode;
        nextNode->prev = prevNode;
    }

    // Insert node right after head (most recent)
    void insert(Node* node) {
        Node* nextNode = head->next;

        head->next = node;
        node->prev = head;

        node->next = nextNode;
        nextNode->prev = node;
    }

public:
    LRUCache(int cap) {
        capacity = cap;

        head = new Node(-1, -1); // dummy head
        tail = new Node(-1, -1); // dummy tail

        head->next = tail;
        tail->prev = head;
    }

    int get(int key) {
        if (mp.find(key) == mp.end()) return -1;

        Node* node = mp[key];
        remove(node);     // remove from current position
        insert(node);     // move to front (most recent)

        return node->value;
    }

    void put(int key, int value) {
        if (mp.find(key) != mp.end()) {
            Node* node = mp[key];
            node->value = value;

            remove(node);
            insert(node);
        } else {
            if (mp.size() == capacity) {
                // remove LRU (node before tail)
                Node* lru = tail->prev;
                remove(lru);
                mp.erase(lru->key);
                delete lru;
            }

            Node* newNode = new Node(key, value);
            insert(newNode);
            mp[key] = newNode;
        }
    }
};