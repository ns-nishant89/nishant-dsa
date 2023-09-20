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
    boolean ans = false;
    HashMap<Integer, Integer> hm = new HashMap<>();
    
    public void dfs(TreeNode root , int k){
        if(root==null) return;
        if(hm.containsKey(k-root.val)) ans = true;
        
        hm.putIfAbsent(root.val,1);
        
        dfs(root.left, k);
        dfs(root.right, k);
        
        return;
    }
    public boolean findTarget(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }
}