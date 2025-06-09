class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : hand) freq.put(x, freq.getOrDefault(x, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(freq.keySet());

        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && freq.get(pq.peek()) == 0) pq.poll();
            if (pq.isEmpty()) break;

            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < groupSize; j++) {
                if (pq.isEmpty()) return false;
                int val = pq.poll();
                while (freq.get(val) == 0) {
                    if (pq.isEmpty()) return false;
                    val = pq.poll();
                }
                arr.add(val);
            }

            for (int i = 0; i < arr.size(); i++) {
                if (i > 0 && arr.get(i) - arr.get(i - 1) != 1) return false;
                int card = arr.get(i);
                int rem = freq.get(card) - 1;
                freq.put(card, rem);
                if (rem > 0) pq.offer(card);
            }
        }
        return true;
    }
}
