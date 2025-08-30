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
     int ans = 0;
    
    public boolean check(HashMap<Integer, Integer> map){
        int cnt = 0;
        for(int it: map.values()){
            if(it % 2 == 1){
                cnt++;
            }
        }
        return cnt <= 1;
    }
    public void dfs(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null) return;
        
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        
        if(root.left == null && root.right == null){
            if(check(map)){
                ans++;
            }
        }
        else{
            dfs(root.left, map);
            dfs(root.right, map);
        }
        map.put(root.val, map.get(root.val) - 1);
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(root == null) return 0; 
        dfs(root, map);
        return ans;
    }
}