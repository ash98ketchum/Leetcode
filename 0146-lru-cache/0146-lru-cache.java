class LRUCache {
    private int capacity;
    private Map<Integer, Integer> storage;
    private LinkedList<Integer> order;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
        order = new LinkedList<>();
    }

    public int get(int key) {
        if (!storage.containsKey(key)) return -1;
        order.remove((Integer) key);
        order.addLast(key);
        return storage.get(key);
    }

    public void put(int key, int value) {
        if (storage.containsKey(key)) {
            storage.put(key, value);
            order.remove((Integer) key);
            order.addLast(key);
            return;
        }

        if (storage.size() == capacity) {
            int leastUsed = order.removeFirst();
            storage.remove(leastUsed);
        }

        storage.put(key, value);
        order.addLast(key);
    }
}
