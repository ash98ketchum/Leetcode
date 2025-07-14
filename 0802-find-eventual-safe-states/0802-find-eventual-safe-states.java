class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            adj.add(new ArrayList<>());
        }

        for(int u = 0; u < graph.length; u++){
            for(int v : graph[u]){
                adj.get(v).add(u);
            }
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
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0){
                    q.offer(it);
                }
            }
        }
        Collections.sort(topo);
        return topo;
        
    }
}