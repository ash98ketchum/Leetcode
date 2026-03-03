class LRUCache {
public:
    int capacity;
    list<pair<int, int>> cache;
    unordered_map<int, list<pair<int,int>>::iterator> mp;
    LRUCache(int capacity) {
        this->capacity = capacity;
    }
    
    int get(int key) {
        if(mp.find(key) == mp.end()) return -1;
        cache.splice(cache.begin(), cache, mp[key]);
        return mp[key]->second;
    }
    
    void put(int key, int value) {
        if(mp.find(key) != mp.end()){
            mp[key]->second = value;
            cache.splice(cache.begin(), cache, mp[key]);
        }
        else{
            if(cache.size() == capacity){
                int lrukey = cache.back().first;
                cache.pop_back();
                mp.erase(lrukey);
            }
            cache.push_front({key, value});
            mp[key] = cache.begin();
        }

    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */