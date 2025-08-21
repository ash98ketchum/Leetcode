class Pair{
    int cap;
    int prof;
    Pair(int cap, int prof){
        this.cap = cap;
        this.prof = prof;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Pair[] p = new Pair[n];
        for(int i = 0; i < n; i++){
            p[i] = new Pair(capital[i], profits[i]);
        }

        Arrays.sort(p, (a,b)-> a.cap - b.cap);


        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(b.prof, a.prof));

        int idx = 0;
        for(int i = 0; i < k;i++){
            while(idx < n && w >= p[idx].cap){
                pq.add(p[idx]);
                idx++;
            }

            if(pq.isEmpty()){
                return w;
            }
            w += pq.poll().prof;

        }
        return w;
    }
}