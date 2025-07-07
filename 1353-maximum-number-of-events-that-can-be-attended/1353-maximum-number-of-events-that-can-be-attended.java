class Solution {
    public static class tuple{
        int s;
        int e;
        int idx;
        
        tuple(int s, int e, int idx){
            this.s = s;
            this.e = e;
            this.idx = idx;
        }
    }
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0, res = 0;

        int lastDay = 0;
        for (int[] e : events) {
            lastDay = Math.max(lastDay, e[1]);
        }

        for (int day = 1; day <= lastDay; day++) {
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }
        }
            return res;
    }
}