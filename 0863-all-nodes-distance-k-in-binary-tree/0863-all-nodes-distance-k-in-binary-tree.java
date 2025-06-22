/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>(); //bache - parent
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        
        q.offer(root);
        // map me bache - parent add krdiye 
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode node = q.poll();
                if(node.left != null) {
                    map.put(node.left, node);
                    q.offer(node.left);
                } 
                if(node.right != null){
                     map.put(node.right, node);
                       q.offer(node.right);
                } 
              
            }
        }
        // again level order
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        q.offer(target);  //new root
        int curr = 0;
        visited.put(target, true);
        while(!q.isEmpty()){
            int n = q.size();
            if(curr == k){
                break;
            }else{
                curr++;
            }
            
            for(int i =0; i < n; i++){
           TreeNode node = q.poll();
           if(node.left != null && visited.get(node.left) == null){
             visited.put(node.left, true);
             q.offer(node.left);
           }
           if(node.right != null && visited.get(node.right) == null){
             visited.put(node.right, true);
             q.offer(node.right);
           }
        //    yaha pr ham ulta ja rhe haina 
           if(map.get(node) != null && visited.get(map.get(node)) == null){
             visited.put(map.get(node), true);
             q.offer(map.get(node));
           }
        }
        }
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
}