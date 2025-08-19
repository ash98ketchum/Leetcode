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
    public void myrec(TreeNode root1, List<Integer> res1){
        if(root1 == null) return;

       if(root1.left != null){
          myrec(root1.left, res1);
       }
       res1.add(root1.val);

       if(root1.right != null){
          myrec(root1.right, res1);
       }

    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        myrec(root1, res1);
        myrec(root2, res2);

        List<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;
        while(i < res1.size() && j < res2.size()){
            if(res1.get(i) < res2.get(j)){
                ans.add(res1.get(i));
                i++;
            }else{
                ans.add(res2.get(j));
                j++;
            }
        }
        while(i < res1.size()){
            ans.add(res1.get(i));
            i++;
        }
        while(j < res2.size()){
            ans.add(res2.get(j));
            j++;
        }
        return ans;
    }
}