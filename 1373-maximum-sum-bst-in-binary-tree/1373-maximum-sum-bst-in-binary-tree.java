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
    static int ans;
    public int maxSumBST(TreeNode root) {
        ans = 0;
        jaiBabaKi(root);
        return ans;
    }
    public int[] jaiBabaKi(TreeNode curr){
        if (curr.left==null && curr.right==null){
            ans = Math.max(ans,curr.val);
            return new int[]{curr.val,curr.val,curr.val};
        }
        if (curr.left!=null){
            int[] left = jaiBabaKi(curr.left);
            if (curr.right!=null){
                int[] right = jaiBabaKi(curr.right);
                if (curr.val>left[1] && curr.val<right[0]){
                    if (left[0]<=left[1] && right[0]<=right[1]){
                        ans = Math.max(ans,left[2]+right[2]+curr.val);
                    }
                    
                    return new int[]{left[0],right[1],left[2]+right[2]+curr.val};
                }
                return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,left[2]+right[2]+curr.val};
            }
            else{
                if (curr.val>left[1] && left[0]<=left[1]){
                    ans = Math.max(ans,left[2]+curr.val);
                    return new int[]{left[0],curr.val,left[2]+curr.val};
                }
                return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,left[2]+curr.val};
            }
        }
        else{
            int[] right = jaiBabaKi(curr.right);
            if (curr.val<right[0] && right[0]<=right[1]){
                ans = Math.max(ans,right[2]+curr.val);
                return new int[]{curr.val,right[1],right[2]+curr.val};
            }
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,right[2]+curr.val};
        }
    
    }
}