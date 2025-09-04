class Solution {
    public boolean dfs(boolean vis[], List<List<Integer>> adj, int node, int parent, boolean rec[]){
        vis[node] = true;
        rec[node] = true;
        for(int it: adj.get(node)){
            if(!vis[it] && dfs(vis, adj, it, node, rec) == true){
                return true;
            }else if(rec[it] == true){
                return true;
            }
        }
        rec[node] = false;
        return false;
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // -------------ek bacche ke do papa na ho-----------------------
        
        int parent[] = new int[n];
        Arrays.fill(parent, -1);    //[-1, -1, -1...n]

        for(int i = 0; i < n; i++){
            if(leftChild[i] != -1 && parent[leftChild[i]] == -1){
                parent[leftChild[i]] = i;   //bacche ko uska shi papa diya
            }else if(leftChild[i] != -1){
                return false;
            }
            if(rightChild[i] != -1 && parent[rightChild[i]] == -1 ){
                parent[rightChild[i]] = i;   //bacche ko uska shi papa diya
            }else if(rightChild[i] != -1){
                return false;
            }
        }

        // -----------ek hi root ho (sirf root node ka papa -1 hota hai)-----
        int root = -1;
        for(int i = 0; i < n; i++){
            if(parent[i] == -1){
                if(root == -1) root = i;
                else return false;   //multiple roots
            }
        }
        if(root == -1) return false;  //no root

        // -----------baccha papa same na ho-----------(cycle na ho)
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            if(leftChild[i] != -1) adj.get(i).add(leftChild[i]);
            if(rightChild[i] != -1) adj.get(i).add(rightChild[i]);
        }

        boolean vis[] = new boolean[n];
        boolean rec[] = new boolean[n];  //path store

        if(dfs(vis, adj, root, -1, rec)){ //if cycle 
            return false;
        }

        // -----------sab node connected ho (forest na bane)-----------
        for(int i = 0; i < n; i++){
            if(!vis[i]) return false;
        }

        return true;
    }
}
