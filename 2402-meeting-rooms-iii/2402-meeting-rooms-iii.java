import java.util.*;

class Solution {
    class tuple {
        int room;
        long endtime;
        tuple(int room, long endtime) {
            this.room = room;
            this.endtime = endtime;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> emptyroom = new PriorityQueue<>();
        for (int room = 0; room < n; room++) emptyroom.offer(room);

        PriorityQueue<tuple> pq = new PriorityQueue<>(
            (a, b) -> a.endtime == b.endtime
                ? Integer.compare(a.room, b.room)
                : Long.compare(a.endtime, b.endtime));

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int[] cnt = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            while (!pq.isEmpty() && pq.peek().endtime <= start)
                emptyroom.offer(pq.poll().room);

            if (!emptyroom.isEmpty()) {
                int room = emptyroom.poll();
                cnt[room]++;
                pq.offer(new tuple(room, end));
            } else {
                tuple t = pq.poll();
                long duration = end - start;
                long newEnd = t.endtime + duration;
                cnt[t.room]++;
                pq.offer(new tuple(t.room, newEnd));
            }
        }

        int maxans = 0;
        for (int i = 1; i < n; i++)
            if (cnt[i] > cnt[maxans]) maxans = i;
        return maxans;
    }
}
