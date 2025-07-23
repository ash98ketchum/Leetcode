class Solution {
    class DSU{
        ArrayList<Integer> parent, rank;
        DSU(int n){
            parent = new ArrayList<>(n);
            rank = new ArrayList<>(n);
            for(int i = 0; i < n; i++){
                parent.add(i);
                rank.add(0);
            }
        }
        public int find(int u){
            int temp = u;
            while(parent.get(u) != u){
                u = parent.get(u);
                
            }
            parent.set(temp, u);
            return u;
        }
        public void union(int u, int v){
            int ULT_u = find(u);
            int ULT_v = find(v);

            if(ULT_u == ULT_v){
                return;
            }

            if(rank.get(ULT_u) > rank.get(ULT_v)){
                rank.set(ULT_u, rank.get(ULT_u) + 1);
                parent.set(ULT_v, ULT_u);
            }
            else if(rank.get(ULT_v) > rank.get(ULT_u)){
                rank.set(ULT_v, rank.get(ULT_v) + 1);
                parent.set(ULT_u, ULT_v);
            }
            else{
                rank.set(ULT_u, rank.get(ULT_u) + 1);
                parent.set(ULT_v, ULT_u);
            }

        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail)){
                    dsu.union(i, map.get(mail));
                }
                else{
                    map.put(mail, i);
                }
            }
        }
        ArrayList<String>[] arr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }
        for(Map.Entry<String, Integer> it : map.entrySet()){
            String mail = it.getKey();
            int node = dsu.find(it.getValue());
            arr[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(arr[i].size() == 0) continue;
            Collections.sort(arr[i]);
            
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));

            for(String it : arr[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;

        
    }
}