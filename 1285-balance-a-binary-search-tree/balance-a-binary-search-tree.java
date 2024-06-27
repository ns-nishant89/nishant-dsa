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
    List<TreeNode> sortedArr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorderTraversal(root);
        return sortedArrToBST(0,sortedArr.size()-1);
    }
    void inorderTraversal(TreeNode root){
        if(root==null) return;
        inorderTraversal(root.left);
        sortedArr.add(root);
        inorderTraversal(root.right);
    }
    TreeNode sortedArrToBST(int start,int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode root = sortedArr.get(mid);
        root.left = sortedArrToBST(start,mid-1);
        root.right = sortedArrToBST(mid+1,end);
        return root;
    } 
}