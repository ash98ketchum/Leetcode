class Solution {
    public int time = 0;
    public void dfs(int node, int par, int intime[], int lowtime[],List<List<Integer>> adj, int n, List<List<Integer>> res, boolean vis[]){
        vis[node] = true;
        intime[node] = time;
        lowtime[node] = time;
        time++;

        for(int it : adj.get(node)){
            if(it == par) continue;
            if(!vis[it]){
                dfs(it, node, intime, lowtime, adj, n, res, vis);
                lowtime[node] = Math.min(lowtime[node], lowtime[it]);
                if(lowtime[it] > intime[node]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(node);
                    temp.add(it);
                    res.add(temp);
                }
                
            }
            else{
                lowtime[node] = Math.min(lowtime[node], lowtime[it]);
            }
        }

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n;i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> it : edges){
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        int intime[] = new int[n];
        int lowtime[] = new int[n];

        List<List<Integer>> res = new ArrayList<>();
        dfs(0, -1, intime, lowtime, adj, n, res, vis);
        return res;

    }
}