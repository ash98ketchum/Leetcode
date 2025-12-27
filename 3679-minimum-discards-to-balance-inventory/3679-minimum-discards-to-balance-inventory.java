class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int n = arrivals.length;

        Map<Integer, Deque<Integer>> mp = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int d = i + 1;
            int it = arrivals[i];
            int win = d - w + 1;

            Deque<Integer> dq = mp.computeIfAbsent(it, k->new ArrayDeque<>());
            while(!dq.isEmpty() && dq.peekFirst() < win){
                dq.pollFirst();
            }
            if(dq.size() < m){
                dq.offerLast(d);
            }
            else{
                cnt++;
            }
        }
        return cnt;
    }
}