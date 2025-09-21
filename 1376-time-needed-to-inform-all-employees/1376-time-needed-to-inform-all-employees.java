class Solution {
    class Pair{
        int employee;
        int time;
        Pair(int employee, int time){
            this.employee = employee;
            this.time = time;
        }
    }
    public int numOfMinutes(int n, int headId, int[] manager, int[] infoTime) {
    List<List<Pair>> adj = new ArrayList<>();
    for(int i = 0; i < n; i++){
        adj.add(new ArrayList<>());
    }
    for(int i = 0; i < n; i++){ 
        if(manager[i] == -1) continue;
        adj.get(manager[i]).add(new Pair(i, infoTime[manager[i]]));
    }
    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.time, b.time));

    int dist[] = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[headId] = 0;
    pq.offer(new Pair(headId, 0));
    int max = Integer.MIN_VALUE;
    while(!pq.isEmpty()){
        Pair curr = pq.poll();
        int currEmpl = curr.employee;
        int currTime = curr.time;

        for(Pair it: adj.get(currEmpl)){
            int nextEmp = it.employee;
            int nextTime = it.time;
            if(dist[currEmpl] +  nextTime < dist[nextEmp]){
                dist[nextEmp] = dist[currEmpl] +  nextTime;
                pq.offer(new Pair(nextEmp, nextTime));
            }
        }
    }
    for(int it: dist){
        max = Math.max(it, max);
    }
    
    return max;
        
    }
}