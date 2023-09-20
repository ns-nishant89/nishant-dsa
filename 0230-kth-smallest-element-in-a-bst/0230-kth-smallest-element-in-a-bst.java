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
    public int kthSmallest(TreeNode root, int k) {
     List<Integer> res =new ArrayList<>();
     solve(root,res);
     return res.get(k-1);   
    }
    public void solve(TreeNode root,List<Integer> res){
        if(root==null) return;
        solve(root.left,res);
        res.add(root.val);
        solve(root.right,res);
    }
}