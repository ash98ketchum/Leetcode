class Solution {
    public int[] findOrder(int n, int[][] preq) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <  n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < preq.length; i++){
            int u = preq[i][0];
            int v = preq[i][1];
            adj.get(v).add(u);
        }
        int indeg[] = new int[n];
        for(int i = 0; i < n; i++){
            for(int it : adj.get(i)){
                indeg[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indeg[i] == 0) q.offer(i);
        }

        int ans[] = new int[n];
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            // vis[node] = true;
            ans[idx++] = node;
            for(int child : adj.get(node)){
                indeg[child]--;
                if(indeg[child]==0){
                    q.offer(child);
                }
            }
        }
        if(idx == n) return ans;
        else return new int[0];
        
    }
}