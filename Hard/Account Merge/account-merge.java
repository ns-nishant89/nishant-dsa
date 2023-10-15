//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java
  // code here
  class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    // Constructor to initialize the DisjointSet with 'n' elements
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0); // Initialize the rank of each element to 0
            parent.add(i); // Initialize the parent of each element to itself
            size.add(1); // Initialize the size of each set to 1
        }
    }

    // Find the ultimate parent of a node with path compression
    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node; // If the node is its own parent, it's the ultimate parent
        }
        int ulp = findUPar(parent.get(node)); // Recursively find the ultimate parent
        parent.set(node, ulp); // Path compression: Update the parent to the ultimate parent
        return parent.get(node); // Return the ultimate parent
    }

    // Union two sets by size
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u); // Find the ultimate parent of set containing 'u'
        int ulp_v = findUPar(v); // Find the ultimate parent of set containing 'v'
        if (ulp_u == ulp_v) return; // If both sets already have the same parent, do nothing
        if (size.get(ulp_u) < size.get(ulp_v)) {
            // Attach the smaller set (ulp_u) to the larger set (ulp_v)
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); // Update the size of ulp_v
        } else {
            // Attach the smaller set (ulp_v) to the larger set (ulp_u)
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v)); // Update the size of ulp_u
        }
    }
}
class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<String, Integer>();

        // Traverse the input 'details' list to build the DisjointSet and map mail to node
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                } else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<String>();

        // Build a list of merged mail for each node
        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        // Construct the final merged accounts list
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]); // Sort the merged mail list
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // Add the name of the account
            temp.addAll(mergedMail[i]); // Add the sorted mail addresses
            ans.add(temp); // Add the account to the final answer
        }
        return ans;
    }
}
 

     