class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        if (n == 1) return new ArrayList<>(Arrays.asList(0));
        
        for(int it[]: edges){
            int u = it[0];
            int v = it[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[n];

        for(List<Integer> l : adj){
            for(int it: l){
                indegree[it]++;
            }
        }
        for(int i = 0; i < n; i++){
            if(indegree[i] == 1){
                q.offer(i);
            }
        }
        int val = n;
        List<Integer> res = new ArrayList<>();
        while(val > 2){
            int num = q.size();
            val -= num;
            for(int i = 0; i < num; i++){
                int node = q.poll();
                for(int child : adj.get(node)){
                    indegree[child]--;
                    if(indegree[child] == 1){
                        q.offer(child);
                    }
                }
            }
        }
        while(!q.isEmpty()){
            res.add(q.poll());
        }
        return res;
    }
}