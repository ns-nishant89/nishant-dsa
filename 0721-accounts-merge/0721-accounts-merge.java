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
    static List<List<String>> accountsMerge(List<List<String>> details) {
        int n = details.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<String, Integer>();

        // Traverse the input 'details' list to build the DisjointSet and map mail to node
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < details.get(i).size(); j++) {
                String mail = details.get(i).get(j);
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
            temp.add(details.get(i).get(0)); // Add the name of the account
            temp.addAll(mergedMail[i]); // Add the sorted mail addresses
            ans.add(temp); // Add the account to the final answer
        }
        return ans;
    }
}