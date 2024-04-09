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
    private void DFS(TreeNode root,StringBuilder s){
        if(root==null) return;
        if(root.left==null && root.right==null) s.append(root.val).append("*");
        DFS(root.left,s);
        DFS(root.right,s);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    StringBuilder t1 = new StringBuilder();
    StringBuilder t2 = new StringBuilder();
    DFS(root1,t1);
    DFS(root2,t2);
    return t1.toString().equals(t2.toString());
    }
}