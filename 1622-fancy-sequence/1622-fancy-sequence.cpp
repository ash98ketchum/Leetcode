class Fancy {
private:
    const int MOD = 1e9 + 7;
    const int MAXN = 100005;
    
    int seq_len;
    vector<long long> tree;
    vector<long long> lazy_add;
    vector<long long> lazy_mul;

    void push_down(int node) {
        if (lazy_add[node] == 0 && lazy_mul[node] == 1) return;
        
        int left = 2 * node;
        int right = 2 * node + 1;
        lazy_mul[left] = (lazy_mul[left] * lazy_mul[node]) % MOD;
        lazy_add[left] = (lazy_add[left] * lazy_mul[node] + lazy_add[node]) % MOD;
        tree[left] = (tree[left] * lazy_mul[node] + lazy_add[node]) % MOD;
        lazy_mul[right] = (lazy_mul[right] * lazy_mul[node]) % MOD;
        lazy_add[right] = (lazy_add[right] * lazy_mul[node] + lazy_add[node]) % MOD;
        tree[right] = (tree[right] * lazy_mul[node] + lazy_add[node]) % MOD;
        lazy_mul[node] = 1;
        lazy_add[node] = 0;
    }

    void update(int node, int start, int end, int l, int r, long long m, long long a) {
        if (l > end || r < start) return;
        
        if (l <= start && end <= r) {
            lazy_mul[node] = (lazy_mul[node] * m) % MOD;
            lazy_add[node] = (lazy_add[node] * m + a) % MOD;
            tree[node] = (tree[node] * m + a) % MOD;
            return;
        }
        
        push_down(node);
        int mid = start + (end - start) / 2;
        update(2 * node, start, mid, l, r, m, a);
        update(2 * node + 1, mid + 1, end, l, r, m, a);
    }

    void insert(int node, int start, int end, int idx, long long val) {
        if (start == end) {
            tree[node] = val;
            lazy_mul[node] = 1;
            lazy_add[node] = 0;
            return;
        }
        
        push_down(node);
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            insert(2 * node, start, mid, idx, val);
        } else {
            insert(2 * node + 1, mid + 1, end, idx, val);
        }
    }

    long long query(int node, int start, int end, int idx) {
        if (start == end) {
            return tree[node];
        }
        
        push_down(node);
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            return query(2 * node, start, mid, idx);
        } else {
            return query(2 * node + 1, mid + 1, end, idx);
        }
    }

public:
    Fancy() {
        seq_len = 0;
        int tree_size = 4 * MAXN;
        tree.assign(tree_size, 0);
        lazy_add.assign(tree_size, 0);
        lazy_mul.assign(tree_size, 1);
    }
    
    void append(int val) {
        insert(1, 0, MAXN, seq_len, val);
        seq_len++;
    }
    
    void addAll(int inc) {
        if (seq_len > 0){
            update(1, 0, MAXN, 0, seq_len - 1, 1, inc);
        }
    }
    
    void multAll(int m) {
        if (seq_len > 0){
            update(1, 0, MAXN, 0, seq_len - 1, m, 0);
        }
    }
    
    int getIndex(int idx) {
        if (idx >= seq_len) {
            return -1;
        }
        return query(1, 0, MAXN, idx);
    }
};