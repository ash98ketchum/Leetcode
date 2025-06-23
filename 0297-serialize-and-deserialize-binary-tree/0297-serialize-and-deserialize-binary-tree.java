/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                 sb.append("* ");
                 continue;
            }
            sb.append(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString(); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if(data.equals("")) return null;
       
       Queue<TreeNode> q = new LinkedList<>();
       String a[] = data.split(" ");
       
       TreeNode node = new TreeNode(Integer.parseInt(a[0]));
       q.offer(node);
       
       for(int i = 1; i < a.length; i++){
         TreeNode node2 = q.poll();
         if(!a[i].equals("*")){
            node2.left = new TreeNode(Integer.parseInt(a[i]));
            q.offer(node2.left);
         }
         i++;
         if(!a[i].equals("*")){
            node2.right = new TreeNode(Integer.parseInt(a[i]));
            q.offer(node2.right);
            
         }
       }
       return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));