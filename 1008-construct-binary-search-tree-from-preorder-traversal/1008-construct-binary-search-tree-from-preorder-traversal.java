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
class Solution {
    public TreeNode myrec(int preorder[], int inorder[], int s1, int e1, int s2, int e2, HashMap<Integer,Integer> map){
        if(s1 > e1 || s2 > e2){
            return null;
        }
        int curr = preorder[s1];
        int inorderidx = map.get(curr);
        int rem = inorderidx - s2;
        TreeNode node = new TreeNode(curr);
    
        node.left = myrec(preorder, inorder, s1 + 1, s1 + inorderidx, s2, inorderidx - 1, map);
        node.right = myrec(preorder, inorder,s1 + rem + 1 ,e1,inorderidx + 1, e2,map);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int []inorder = new int[preorder.length];
        for(int i = 0; i < preorder.length; i++){
            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return myrec(preorder,inorder,0,preorder.length-1, 0, inorder.length-1,map);
        
    }
}