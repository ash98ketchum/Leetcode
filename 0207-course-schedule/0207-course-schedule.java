class Solution {
    public boolean canFinish(int n, int[][] preq) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < preq.length; i++){
            int u = preq[i][0];
            int v = preq[i][1];
            adj.get(u).add(v);
        }
        int indegree[] = new int[n];
        for(int i = 0; i < n; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i <n; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int top[] = new int[n];  
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            top[idx++] = node;

            for(int child : adj.get(node)){
                indegree[child]--;
                if(indegree[child] == 0){
                    q.offer(child);
                }
            }
        }
        if(idx == n) return true;
        return false;
    }
}