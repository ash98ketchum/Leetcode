class Solution{
    struct TrieNode {
    TrieNode *l[2];
    bool containsKey(int ind) {
        return (l[ind] != NULL); 
    }
    TrieNode* get(int ind) {
        return l[ind]; 
    }
    void put(int ind, TrieNode* node) {
        l[ind] = node; 
    }
}; 
class Trie {
private:
    TrieNode* root; 

public:
    Trie() {
        root = new TrieNode(); 
    }
    
public:
    void insert(int num) {
        TrieNode* node = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(!node->containsKey(bit)) {
                node->put(bit, new TrieNode()); 
            }
            node = node->get(bit); 
        }
    }

public:
    int findMax(int num) {
        TrieNode* node = root; 
        int maxNum = 0;
        for(int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            if(node->containsKey(!bit)) {
                maxNum = maxNum | (1 << i);
                node = node->get(!bit); 
            }
            else {
                node = node->get(bit); 
            }
        }
        
        return maxNum; 
    }
};
public:
vector<int> maximizeXor(vector<int> &arr, vector<vector<int>> &queries){
    vector<int> ans(queries.size(), 0); 
    vector<pair<int, pair<int,int>>> q;
    sort(arr.begin(), arr.end()); 
    
    int index = 0;
    for(auto &it: queries) {
        q.push_back({it[1],{it[0], index++}}); 
    }
    sort(q.begin(), q.end());
    int i = 0; 
    int n = arr.size(); 
    Trie trie; 
    for(auto &it : q) {
        while(i < n && arr[i] <= it.first) {
            trie.insert(arr[i]); 
            i++; 
        }
        
        if(i != 0) 
            ans[it.second.second] = trie.findMax(it.second.first); 
        else 
            ans[it.second.second] = -1; 
    }
    return ans; 
}};