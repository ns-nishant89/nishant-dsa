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
      class Pair{
    TreeNode root;
    int row;
    int col;
    Pair (TreeNode node,int rw ,int cl)
    {
        root=node;
        row=rw;
        col=cl;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap <>();
        Queue <Pair> q=new LinkedList <Pair>();
        q.add( new Pair (root,0,0));
        while(q.size()!=0)
        {
            Pair temp=q.poll();
            TreeNode rt=temp.root;
            int rw =temp.row;
            int cl=temp.col;
            if(!map.containsKey(rw))
                map.put(rw,new TreeMap());
            
            if(!map.get(rw).containsKey(cl))
                map.get(rw).put(cl,new PriorityQueue());
               map.get(rw).get(cl).offer(rt.val);
            
            if(rt.left!=null)
               q.offer(new Pair(rt.left,rw-1,cl+1));
            if(rt.right!=null)
               q.offer(new Pair(rt.right,rw+1,cl+1));
        }
               List<List<Integer>> res =new ArrayList();
               for(TreeMap<Integer,PriorityQueue<Integer>> ans:map.values())
               {
                   res.add(new ArrayList());
                   for(PriorityQueue<Integer> temp:ans.values())
                   {
                       while(temp.size()!=0)
                       {
                           res.get(res.size()-1).add(temp.poll());
                       }
                   }
                   
               }
               return res;
    }
 }
        

