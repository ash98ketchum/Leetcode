class RecentCounter {
    Deque<Integer> dq;
    public RecentCounter() {
        dq = new ArrayDeque<>();
    }

    public int ping(int t) {
        dq.addLast(t);
        int start = t - 3000;
        while (!dq.isEmpty() && dq.peekFirst() < start) {
            dq.pollFirst();
        }
        return dq.size();
    }
}


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */