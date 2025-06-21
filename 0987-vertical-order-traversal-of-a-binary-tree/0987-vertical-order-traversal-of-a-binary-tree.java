/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Tuple {
    TreeNode node;
    int index;
    int level;

    public Tuple(TreeNode node, int index, int level) {
        this.node = node;
        this.index = index;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        
        if(root == null) return res;
        q.offer(new Tuple(root, 0, 0));
        
        while(!q.isEmpty()){
            Tuple t = q.poll();  
            TreeNode node = t.node;
            int idx = t.index;
            int level = t.level;
            
            if(!map.containsKey(idx)){ // agar vo index exist nhi karta 
                map.put(idx, new TreeMap<>());
            }
            if(!map.get(idx).containsKey(level)){ // index h but uska level nhi h
                map.get(idx).put(level, new PriorityQueue<>());
            }
            //dono exist karte h 
            map.get(idx).get(level).offer(node.val);
            
            if(node.left != null){
                q.offer(new Tuple(node.left, idx - 1, level + 1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, idx + 1, level + 1));
            }
            
        }
        
        for(TreeMap<Integer, PriorityQueue<Integer>> map2 : map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq : map2.values()){
                while(!pq.isEmpty()){
                    list.add(pq.peek());
                    pq.poll();
                }
            }
            res.add(list);
        }
        return res;
    }
}
